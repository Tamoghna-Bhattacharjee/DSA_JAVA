package Dynamic_programming.LeetCode;

import java.util.Arrays;
import java.util.Scanner;

public class Longest_IncreasingSubsequence {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = scan.nextInt();
        System.out.println(lengthOfLIS(arr));
    }
    static int lengthOfLIS(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;
        int[] dp = new int[n];
        int res = 1;
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) dp[i] = Math.max(dp[i], dp[j]+1);
                res = Math.max(res, dp[i]);
            }
        }
        return res;
    }
}
