package String_algo.DP;

import java.util.Arrays;
import java.util.Scanner;

public class LongestPalindromicSubstring {
    static int[][] dp; // 1-> true 0 -> false -1 -> unknown
    static int maxLen, start, end;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt(); scan.nextLine();
        while (T-- > 0) {
            String s = scan.nextLine();
            System.out.println(solve(s));
        }
    }

    public static String solve(String s) {
        int n = s.length();
        if (n == 0) return "";
        dp = new int[n][n];
        maxLen = 1; start = 0; end = 0;
        for (int i = 0; i < n; i++) Arrays.fill(dp[i], -1);
        topDown(0, n-1, s);
        return s.substring(start, end+1);
    }

    public static int topDown(int i, int j, String s) {
        if (i > j) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        if (i == j) return dp[i][j] = 1;
        dp[i][j] = 0;
        if (i+1 == j && s.charAt(i) == s.charAt(j)) {
            update(i, j);
            return dp[i][j] = 1;
        }
        if (s.charAt(i) == s.charAt(j) && topDown(i+1, j-1, s) > 0) {
            update(i, j);
            return dp[i][j] = 1;
        }
        dp[i+1][j] = topDown(i+1, j, s);
        dp[i][j-1] = topDown(i, j-1, s);
        return dp[i][j];
    }

    public static void update(int i, int j) {
        int len = j-i+1;
        if (len > maxLen || (len == maxLen && i < start)) {
            start = i; end = j; maxLen = len;
        }
    }
}