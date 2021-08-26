package String_algo.DP;

import java.util.Scanner;

// https://leetcode.com/problems/palindrome-partitioning-ii/

public class MinCut_Palindromic_Partitioning {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            if (i+1 < n && s.charAt(i) == s.charAt(i+1)) dp[i][i+1] = true;
        }
        for (int x = 3; x <= n; x++) {
            for (int i = 0; i < n; i++) {
                int j = i+x-1;
                if (j >= n) break;
                dp[i][j] = s.charAt(i) == s.charAt(j) && dp[i+1][j-1];
            }
        }
        int[] cut = new int[n];
        for (int i = 0; i < n; i++) cut[i] = i;

        for (int j = 1; j < n; j++) {
            for (int i = 0; i <= j; i++) {
                if (dp[i][j]) {
                    if (i == 0) cut[j] = 0;
                    else cut[j] = Math.min(cut[j], cut[i-1]+1);
                }
            }
        }
        System.out.println(cut[n-1]);
    }
}
