package Number_Theory;

import java.util.Scanner;

public class Miller_Robin_PrimalityTest {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            long p = scan.nextLong();
            if (isPrime(p)) System.out.println("YES");
            else System.out.println("NO");
        }
    }
    static boolean check_composite(long a, long s, long d, long p) {
        long x = power(a, d, p);
        if (x == p-1 || x == 1) return false;
        for (int i = 1; i < s; i++) {
            x = x * x % p;
            if (x == p-1) return false;
        }
        return true;
    }

    static boolean isPrime(long p) {
        long d = 0, s = 0, x = p-1;
        while (x % 2 == 0) {
            s++; x /= 2;
        }
        d = x;
        long[] a = {2,3,5,7,13,17,19,23,29,31,37};
        for (long i: a) {
            if (i == p) return true;
            if (check_composite(i, s, d, p)) return false;
        }
        return true;
    }
    static long power(long a, long n, long mod) {
        long res = 1;
        while (n > 0) {
            if (n % 2 == 1) res = res * a % mod;
            a = a * a % mod;
            n /= 2;
        }
        return res % mod;
    }
}
