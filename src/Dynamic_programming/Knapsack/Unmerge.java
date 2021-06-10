package Dynamic_programming.Knapsack;

import java.util.ArrayList;
import java.util.Scanner;

// https://codeforces.com/problemset/problem/1381/B
public class Unmerge {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            int n = scan.nextInt();
            int[] p = new int[2*n];
            for (int i = 0; i < 2*n; i++) p[i] = scan.nextInt();
            ArrayList<Integer> list = mkSubsetArray(p, 2*n);
            System.out.println(canSubsetSum(list, n));
        }
    }
    static String canSubsetSum(ArrayList<Integer> arr, int k) {
        int n = arr.size()-1;
        boolean[][] dp = new boolean[n+1][k+1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                if (j < arr.get(i)) dp[i][j] = dp[i-1][j];
                else dp[i][j] = dp[i-1][j] || dp[i-1][j-arr.get(i)];
            }
        }
        return dp[n][k]? "YES": "NO";
    }
    static ArrayList<Integer> mkSubsetArray(int[] p, int lim) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(0); // 1 indexed
        while (true) {
            int max = -1, ind = -1;
            for (int i = 0; i < lim; i++) {
                if (p[i] > max) {
                    max = p[i]; ind = i;
                }
            }
            if (ind == -1) break;
            list.add(lim-ind);
            lim = ind;
        }
        return list;
    }
}
