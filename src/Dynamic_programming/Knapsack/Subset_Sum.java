package Dynamic_programming.Knapsack;

import java.util.Scanner;
// https://www.codechef.com/problems/TF01

public class Subset_Sum {
    public static void main (String[] args) throws java.lang.Exception{
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            int n = scan.nextInt(), k = scan.nextInt();
            int[] arr = new int[n+1];
            for (int i = 1; i <= n; i++) arr[i] = scan.nextInt();
            boolean[][] dp = new boolean[n+1][k+1];
            dp[0][0] = true;
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j <= k; j++) {
                    if (j < arr[i]) dp[i][j] = dp[i-1][j];
                    else dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i]];
                }
            }
            System.out.println((dp[n][k]? 1: 0));
        }
    }
}
