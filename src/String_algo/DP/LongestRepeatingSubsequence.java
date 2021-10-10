package String_algo.DP;

import java.util.Scanner;

// https://practice.geeksforgeeks.org/problems/longest-repeating-subsequence2004/1

public class LongestRepeatingSubsequence {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        int n = s.length();
        s = "#" + s;
        int[][] dp = new int[n+1][n+1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i) == s.charAt(j) && i != j)
                    dp[i][j] = 1 + dp[i-1][j-1];
                else dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
        System.out.println(dp[n][n]);
    }
}
