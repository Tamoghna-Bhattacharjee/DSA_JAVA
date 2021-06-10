package Bitwise;

import java.util.Scanner;
// https://codeforces.com/contest/1362/problem/C

public class JohnnyRatingDrop {
    static long[] dp = new long[60];
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        mkDp();
        while (T-- > 0) {
            long n = scan.nextLong();
            solve(n);
        }
    }
    static void solve(long n) {
        long res = 0;
        for (int i = 59; i >= 0; i--) {
            long F = power(2, i);
            if ((F & n) != 0) {
                res += getPref(i) + (i+1);
            }
        }
        System.out.println(res);
    }
    static long getPref(int ind) {
        long res = 0;
        for (int i = 0; i < ind; i++) res += dp[i];
        return res;
    }
    static void mkDp() {
        long sum = 1;
        dp[0] = 1;
        for (int i = 1; i <= 59; i++) {
            dp[i] = (long) (i+1) + sum;
            sum += dp[i];
        }
    }
    static long power(long a, long n) {
        long res = 1;
        while (n > 0) {
            if (n % 2 == 1) res = res * a;
            a = a*a;
            n /= 2;
        }
        return res;
    }
}
