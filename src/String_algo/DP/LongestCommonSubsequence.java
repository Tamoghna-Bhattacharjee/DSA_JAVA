package String_algo.DP;

import java.util.Scanner;

public class LongestCommonSubsequence {
    static int[][] dp;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s1 = scan.nextLine(), s2 = scan.nextLine();
        System.out.println(topDownUtil(s1, s2));
        System.out.println(bottomUp(s1, s2));
    }
    static int topDownUtil(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        dp = new int[n1][n2];
        return topDown(n1-1, n2-1, s1, s2);
    }
    static int topDown(int i, int j, String s1, String s2) {
        if (i < 0 || j < 0) return 0;
        if (dp[i][j] != 0) return dp[i][j];
        if (s1.charAt(i) == s2.charAt(j)) return dp[i][j] = 1 + topDown(i-1, j-1, s1, s2);
        return dp[i][j] = Math.max(topDown(i-1, j, s1, s2), topDown(i, j-1, s1, s2));
    }

    static int bottomUp(String s1, String s2) {
        int n1= s1.length(), n2=s2.length();
        dp = new int[n1+1][n2+2];
        for(int i=1;i<=n1;i++){
            for(int j=1;j<=n2;j++){
                if(s1.charAt(i-1)==s2.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1]+1;
                else
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
            }
        }
        return dp[n1][n2];
    }

}
