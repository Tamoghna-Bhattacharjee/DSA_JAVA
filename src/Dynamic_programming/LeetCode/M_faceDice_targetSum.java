package Dynamic_programming.LeetCode;

import java.util.Arrays;
import java.util.Scanner;

public class M_faceDice_targetSum {
    static long[][] dp;
    static long mod = 1000000007;
    static int dices, faces, target;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        dices = scan.nextInt(); faces = scan.nextInt(); target = scan.nextInt();
        dp = new long[dices +1][target+1];
        for (long[] a: dp) Arrays.fill(a, -1);
        System.out.println(topDown(dices, target));
    }
    static long topDown(int d, int t) {
        if (t == 0 && d == 0) return dp[d][t] = 1;
        if (t < 0 || d < 0 || d > t) return 0;
        if (dp[d][t] != -1) return dp[d][t];
        dp[d][t] = 0;
        for (int i = 1; i <= faces; i++) {
            dp[d][t] = (dp[d][t] + topDown(d-1, t-i)) % mod;
        }
        return dp[d][t];
    }
}
