package Arrays_algo.Kadane_Algo;

import java.util.Arrays;
import java.util.Scanner;

// you are given an array of length n <= 3000
// get two contiguous sub-array A and B of same length
// find max value of product of corresponding element of A and rev(B)

// test case -> 1 9 2 3 0 6 7 8  => 104

public class Kadane_2D {
    static long[] arr;
    static long[][] dp;
    static long ans;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        arr = new long[n];
        dp = new long[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
        ans = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) arr[i] = scan.nextLong();
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++)
                ans = Math.max(ans, f(i, j));
        }
        System.out.println(ans);
    }
    static long f(int i, int j) {
        if (i >= j) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        return dp[i][j] = Math.max(arr[i]*arr[j] + f(i+1, j-1), arr[i]*arr[j]);
    }
}
