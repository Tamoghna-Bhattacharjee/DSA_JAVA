package String_algo.DP;

import java.util.Arrays;
import java.util.Scanner;

// https://practice.geeksforgeeks.org/problems/interleaved-strings/1#

public class Interleaved_Strings {
    static int n, m;
    static String A, B, C;
    static int[][] dp;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        A = scan.nextLine(); B = scan.nextLine(); C = scan.nextLine();
        n = A.length(); m = B.length();
        dp = new int[n+1][m+1];
        for (int[] i: dp) Arrays.fill(i,-1);
        System.out.println(f(0,0,0));
    }
    static int f(int i, int j, int k) {
        if (k >= n+m) return dp[i][j] = 1;
        if (dp[i][j] != -1) return dp[i][j];
        dp[i][j] = 0;
        if (i < n && j < m) {
            dp[i][j] = (A.charAt(i)==C.charAt(k)? f(i+1,j,k+1): 0) |
                    (B.charAt(j) == C.charAt(k)? f(i,j+1,k+1): 0);
        } else if (i >= n) {
            dp[i][j] = B.charAt(j) == C.charAt(k)? f(i,j+1,k+1): 0;
        } else dp[i][j] = A.charAt(i)==C.charAt(k)? f(i+1,j,k+1): 0;
        return dp[i][j];
    }
}
