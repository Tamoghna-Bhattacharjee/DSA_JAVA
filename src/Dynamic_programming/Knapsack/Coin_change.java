package Dynamic_programming.Knapsack;

// https://leetcode.com/problems/coin-change-2/

public class Coin_change {
    static int[][] dp;
    static int[] c;
    public static int change(int amount, int[] coins) {
        int n = coins.length, k = amount;
        dp = new int[n+1][k+1];
        c = new int[n+1];
        for (int i = 1; i <= n; i++) c[i] = coins[i-1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                if (j < c[i]) dp[i][j] = dp[i-1][j];
                else dp[i][j] = dp[i-1][j] + dp[i][j-c[i]];
            }
        }
        return dp[n][k];
    }
}
