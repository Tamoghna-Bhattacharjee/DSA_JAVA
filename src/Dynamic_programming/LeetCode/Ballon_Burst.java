package Dynamic_programming.LeetCode;

// https://leetcode.com/problems/burst-balloons/

public class Ballon_Burst {
    public static void main(String[] args) {
        int[] ballon = {3,1,5,8};
        System.out.println(burstBalloonUtility(ballon));
    }

    public static int burstBalloonUtility(int[] ballon){
        // temp array has temp[0] = 1 and temp[n] = 1 and rest copies the ballon
        int[] temp = new int[ballon.length + 2];
        int[][] dp = new int[temp.length][temp.length];


        for (int i = 0; i < temp.length; i++){
            if (i == 0 || i == temp.length - 1)
                temp[i] = 1;
            else
                temp[i] = ballon[i - 1];

            dp[0][i] = 1;
            dp[i][0] = 1;
            dp[temp.length - 1][i] = 1;
            dp[i][temp.length - 1] = 1;
        }
        int max_profit = TopDown(temp, 1, ballon.length, dp);
        print_dp(temp, dp);
        return max_profit;
    }

    private static int TopDown(int[] temp, int i, int j, int[][] dp) {
        if (j < i) return 0;
        if (dp[i][j] != 0) return dp[i][j];
        int sum = 0;
        for (int k = i; k <= j; k++){
            int current = TopDown(temp, i, k - 1, dp) + temp[i - 1] * temp[k] * temp[j + 1] +
                            TopDown(temp, k + 1, j, dp);

            if (current > sum)
                sum = current;
        }
        return dp[i][j] = sum;
    }

    private static void print_dp(int[] temp, int[][] dp) {
        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < temp.length; j++) {
                System.out.print("\t" + dp[i][j]);
            }
            System.out.println();
        }
    }

}
