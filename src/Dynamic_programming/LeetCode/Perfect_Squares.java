package Dynamic_programming.LeetCode;

public class Perfect_Squares {
    static int[] dp;
    public static void main(String[] args) {
        System.out.println(numSquares(63));
    }
    private static int numSquares(int n){
        dp = new int[n + 1];
        return util(n) - 1;
    }

    private static int util(int n) {
        if (dp[n] != 0) return dp[n];
        if (n == 0) return dp[n] = 1;
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= Math.sqrt(n); i++){
            min = Math.min(min, util(n - i*i) + 1);
        }
        return dp[n] = min;
    }
}
