package Bitwise;

import java.util.Scanner;

// https://www.codechef.com/MAY20B/problems/CHANDF

public class Chef_and_BitwisePdk {
    static long optimal, max;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            long x = scan.nextLong(), y = scan.nextLong();
            long l = scan.nextLong(), r = scan.nextLong();
            optimal = Long.MAX_VALUE; max = 0;
            System.out.println(solve(x, y, l, r));
        }
    }

    static long solve(long x, long y, long l, long r) {
        if (x == 0 || y == 0 || l == r) {
            return l;
        }
        long or = x|y;
        if (l <= or && or <= r) {
            return or;
        }
        update(x, y, l); update(x, y, r);
        int k = 40;
        // finding the kth bit where l has 0 and r has 1 (because r > l)
        while (getBit(l, k) == getBit(r, k)) k--;
        kth_sameL(x, y, l, or, k);
        kth_sameR(x, y, r, or, k);
        return optimal;
    }
    static void kth_sameL(long x, long y, long l, long or, int k) {
        long z = 0;
        for (int i = 40; i >= k; i--) {
            if (getBit(l, i) == 1) z ^= power(2, i);
        }
        // copy till kth bit => z < r and we need to only make z >= l
        // putting 1 in every bit after kth bit
        // toggling the bits after kth one to 0 iff both x and y has 0 in that position

        for (int i = k-1; i >= 0; i--) z ^= power(2, i);
        update(x, y, z);
        for (int i = k-1; i >= 0; i--) {
            if (getBit(or, i) == 0) {
                long temp = z;
                temp ^= power(2, i);
                if (temp >= l) {
                    update(x, y, temp);
                    z = temp;
                }
            }
        }
    }
    static void kth_sameR (long x, long y, long r, long or, int k) {
        long z = 0;
        for (int i = 40; i >= k; i--) {
            if (getBit(r, i) == 1) z ^= power(2, i);
        }
        // copy 1st k bits => z > l and we now need to make z < r
        // when we get a bit which is 1 in r we toggle it to 0 and append bits of 'or'
        // from that position

        for (int i = k-1; i >= 0; i--) {
            if (getBit(r, i) == 1) {
                long temp = z;
                for (int j = i - 1; j >= 0; j--) {
                    if (getBit(or, j) == 1) temp ^= power(2, j);
                }
                update(x, y, temp);
                z ^= power(2, i);
            }
        }
    }

    static int getBit(long n, int i) {
        long F = power(2, i);
        return (n&F) == F? 1: 0;
    }

    static void update(long x, long y, long z) {
        long curr = f(x, y, z);
        if (curr > max || (curr == max && z < optimal)) {
            max = curr;
            optimal = z;
        }
    }

    static long f(long x, long y, long z) {
        return (x & z) * (y & z);
    }

    static long power(long a, int n) {
        long res = 1;
        while (n > 0) {
            if (n % 2 == 1) res *= a;
            a *= a;
            n /= 2;
        }
        return res;
    }
}
