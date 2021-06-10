package Dynamic_programming.LeetCode;

public class Knight_probability {
    static final double p = 1.0 / 8.0;
    public static void main(String[] args) {
        int N = 8, k = 30, r = 6, c = 4;
        double[][][] dp = new double[N][N][k + 1];
        System.out.println(knight_dp(N, k, r, c, dp));
    }

    private static double knight_dp(int N, int k, int r, int c, double[][][] dp){
        if (r < 0 || r >= N || c < 0 || c >= N)
            return (double) 0;
        else if (k == 0)
            return (double) 1;

        if (dp[r][c][k] != 0.0)
            return dp[r][c][k];

        return dp[r][c][k] = p * knight_dp(N, k - 1, r + 1, c + 2, dp) +
                            p * knight_dp(N, k - 1, r + 1, c - 2, dp) +
                            p * knight_dp(N, k - 1, r - 1, c + 2, dp) +
                            p * knight_dp(N, k - 1, r - 1, c - 2, dp) +
                            p * knight_dp(N, k - 1, r - 2, c - 1, dp) +
                            p * knight_dp(N, k - 1, r - 2, c + 1, dp) +
                            p * knight_dp(N, k - 1, r + 2, c + 1, dp) +
                            p * knight_dp(N, k - 1, r + 2, c - 1, dp);

    }
}
