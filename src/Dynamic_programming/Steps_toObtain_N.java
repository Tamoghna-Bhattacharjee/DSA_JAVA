package Dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Steps_toObtain_N {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] dp = new int[5*n]; Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; dp[1] = 1;
        for (int i = 1; i <= n; i++) {
            if (dp[i] != Integer.MAX_VALUE) {
                dp[i+1] = Math.min(dp[i+1], dp[i] + 1);
                dp[2*i] = Math.min(dp[2*i], dp[i] + 1);
                dp[3*i] = Math.min(dp[3*i], dp[i] + 1);
            } else dp[i] = 0;
        }
        System.out.println(dp[n]);
        ArrayList<Integer> seq = new ArrayList<>();
        while (n >= 1) {
            seq.add(n);
            if (dp[n] == dp[n-1] + 1) n--;
            else if (n % 2 == 0 && dp[n] == dp[n/2] + 1) n/=2;
            else if (n % 3 == 0 && dp[n] == dp[n/3] + 1) n/=3;
        }
        Collections.reverse(seq);
        System.out.println(seq);
    }
}
