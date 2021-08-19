package String_algo.DP;

import java.util.Arrays;
import java.util.Scanner;

public class Cnt_Palindromic_Subsequence {
    static long MOD = 1000000007;
    static long[][] dp;
    static int n;
    static String s;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        s = scan.nextLine();
        n = s.length();
        dp = new long[n][n];
        for (long[] i: dp) Arrays.fill(i,-1);
        System.out.println(getCnt(0,n-1));
    }
    static long getCnt(int i, int j) {
        if (i > j) return 0;
        if (i == j) return dp[i][j] = 1;
        if (dp[i][j] != -1) return dp[i][j];
        if (s.charAt(i) == s.charAt(j))
            dp[i][j] = (1 + getCnt(i+1,j) + getCnt(i,j-1)) % MOD;
        else
            dp[i][j] = (MOD + getCnt(i+1,j) + getCnt(i,j-1) - getCnt(i+1,j-1)) % MOD;
        return dp[i][j];
    }
}