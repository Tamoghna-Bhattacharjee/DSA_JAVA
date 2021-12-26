package String_algo.DP;

// https://practice.geeksforgeeks.org/problems/form-a-palindrome1455/1

import java.util.Scanner;

public class Min_Insertion_toMake_Pallindrome {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        int n = s.length();
        int[][] dp = new int[n+1][n+1];
        s = "#" + s;
        for (int len = 2; len <= n; len++) {
            for (int i = 1; i <= n; i++) {
                int j = i+len-1;
                if (j > n) break;
                if (s.charAt(i) == s.charAt(j)) dp[i][j] = dp[i+1][j-1];
                else dp[i][j] = Math.min(dp[i+1][j], dp[i][j-1]) + 1;
            }
        }
        System.out.println(dp[1][n]);
    }
}
