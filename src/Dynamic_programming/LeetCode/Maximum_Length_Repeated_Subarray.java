package Dynamic_programming.LeetCode;

//Given two integer arrays A and B, return the maximum length of an subarray that appears
// in both arrays.
//Example 1:
//Input:
//A: [1,2,3,2,1]
//B: [3,2,1,4,7]
//Output: 3
//Explanation:
//The repeated subarray with maximum length is [3, 2, 1].

import java.util.Arrays;

public class Maximum_Length_Repeated_Subarray {
    public static void main(String[] args) {
        int[] A = {1,2,3,2,1};
        int[] B = {3,2,1,4,7};
        System.out.println(findLength_iter(A, B));
        System.out.println(findLength_recur(A, B));
    }
    public static int findLength_iter(int[] A, int[] B) {
        int row = A.length, col = B.length;
        int[][] dp = new int[row][col];
        int max = 0;
        for (int i = row-1; i >= 0; i--) {
            for (int j = col-1; j >= 0; j--) {
                if (A[i] == B[j])
                    dp[i][j] = 1 + (i+1 < row && j+1 < col? dp[i+1][j+1]: 0);
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }


    static int[][] dp;
    static int[] max = new int[1];
    public static int findLength_recur(int[] A, int[] B) {
        int row = A.length, col = B.length;
        dp = new int[row][col];
        for (int i = 0; i < row; i++)
            Arrays.fill(dp[i], -1);
        f(row-1, col-1, A, B);
        return max[0];
    }
    public static int f(int i, int j, int[] A, int[] B) {
        if (i < 0 || j < 0)
            return 0;
        if (dp[i][j] == -1) {
            dp[i][j] = 0;
            if (A[i] == B[j]) dp[i][j] = 1 + f(i-1, j-1, A, B);
            f(i-1, j, A, B);
            f(i, j-1, A, B);
        }
        max[0] = Math.max(max[0], dp[i][j]);
        return dp[i][j];
    }
}
