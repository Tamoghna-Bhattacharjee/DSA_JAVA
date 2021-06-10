package Dynamic_programming.Force;

// https://codeforces.com/contest/1447/problem/D

import java.util.Arrays;
import java.util.Scanner;

public class Catching_Cheaters {
    static int n, m;
    static String a, b;
    static int[][] dp;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt(); m = scan.nextInt(); scan.nextLine();
        a = scan.nextLine(); b = scan.nextLine();
        dp = new int[n][m];
        for (int[] i: dp) Arrays.fill(i,-1);
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) ans = Math.max(ans, f(i,j));
        }
        System.out.println(ans);
    }
    static int f (int i, int j) {
        if (i >= n || j >= m) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        int res = 0;
        if (a.charAt(i) == b.charAt(j)) res = Math.max(res, f(i+1, j+1) + 4 - 2);
        else res = Math.max(res, Math.max(f(i+1, j) - 1, f(i, j+1) - 1));
        return dp[i][j] = res;
    }
}
