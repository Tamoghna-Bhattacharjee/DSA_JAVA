package Dynamic_programming.LeetCode;

import java.util.Arrays;

public class Maximum_Square_1s {
    public static void main(String[] args) {
        char[][] matrix = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}};
        System.out.println(maximalSquare(matrix));
    }
    public static int maximalSquare(char[][] matrix) {
        // matrix - (n X m)
        int n = matrix.length; if (n == 0) return 0;
        int m = matrix[0].length; if (m == 0) return 0;
        if (n == 1 && m == 1) return matrix[0][0] == '1'? 1: 0;

        int[][] dp = new int[n][m];
        int max = Integer.MIN_VALUE;
        // filling 1st row
        for (int i = 0; i < m; i++) {
            dp[0][i] = matrix[0][i] - 48;
            max = Math.max(max, dp[0][i]);
        }
        // filling 1st col
        for (int i = 0; i < n; i++){
            dp[i][0] = matrix[i][0] - 48;
            max = Math.max(max, dp[i][0]);
        }
        //dp(i, j) = bottom right corner, declaring order of the matrix;
        for (int i = 1; i < n; i++){
            for (int j = 1; j < m; j++){
                if (matrix[i][j] == '1')
                    dp[i][j] = Math.min(Math.min(dp[i][j-1], dp[i-1][j]), dp[i-1][j-1]) + 1;
                max = Math.max(max, dp[i][j]);
            }
        }
        for (int i = 0; i < n; i++)
            System.out.println(Arrays.toString(dp[i]));
        return max * max;
    }
}
