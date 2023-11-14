package String_algo.DP;

import java.util.Arrays;
import java.util.Scanner;

// https://leetcode.com/problems/count-different-palindromic-subsequences/
// Transition is similar to finding num of palindromic subsequence except here we
// add the bounding char as the state

public class Cnt_unique_Palindromic_Subseq {
    static long[][][] dp;
    static long MOD = 1000000007;
    static String s;

    static long f(int L, int R, int c) {
        if (L > R) return 0;
        if (L == R) return dp[L][R][c] = s.charAt(L)-'a' == c? 1: 0;
        if (dp[L][R][c] != -1) return dp[L][R][c];
        long ans = 0;
        if (s.charAt(L) == s.charAt(R) && s.charAt(L)-'a' == c) {
            ans += 2;
            for (char ch = 0; ch < 26; ch++) {
                ans += f(L+1, R-1, ch);
                ans %= MOD;
            }
        } else {
            ans = (f(L+1, R, c) + f(L, R-1, c) - f(L+1, R-1, c) + MOD) % MOD;
        }
        return dp[L][R][c] = ans;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        s = scan.nextLine();
        int n = s.length();

        dp = new long[n][n][26];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int c = 0; c < 26; c++) dp[i][j][c] = -1;
            }
        }

        long ans = 0;
        for (char ch = 0; ch < 26; ch++) {
            ans += f(0, n-1, ch) % MOD;
            ans %= MOD;
        }
        System.out.println(ans);
    }
}
