package String_algo.DP;

import java.util.Arrays;
import java.util.Scanner;

public class GetMax_A_with4Keys {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println(getMaxA(n));
    }

    static int getMaxA(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1; dp[2] = 2; dp[3] = 3;
        for (int i = 4; i <= n; i++) {
            dp[i] = i;
            for (int j = i-3, mul = 2; j >= 0; j--, mul++) {
                dp[i] = Math.max(dp[i], mul*dp[j]);
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }
}
