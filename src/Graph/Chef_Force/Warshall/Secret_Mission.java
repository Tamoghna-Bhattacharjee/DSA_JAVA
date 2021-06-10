package Graph.Chef_Force.Warshall;

import java.util.Arrays;
import java.util.Scanner;
// https://www.codechef.com/problems/SECRETMI

public class Secret_Mission {
    static int[] B, pre;
    static int[][] dp, g;
    static int cnt;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            int n = scan.nextInt(), m = scan.nextInt(), l = scan.nextInt();
            B = new int[l];
            pre = new int[l];
            for (int i = 0; i  < l; i++) B[i] = scan.nextInt();
            dp = new int[n+1][n+1];
            g = new int[n+1][n+1];
            for (int[] i: dp) Arrays.fill(i, Integer.MAX_VALUE);
            for (int[] i: g) Arrays.fill(i, Integer.MAX_VALUE);
            for (int i = 1; i <= n; i++) {
                dp[i][i] = 0; g[i][i] = 0;
            }
            while(m-- > 0) {
                int u = scan.nextInt(), v = scan.nextInt(), w = scan.nextInt();
                dp[u][v] = w; dp[v][u] = w; g[u][v] = w; g[v][u] = w;
            }
            //make prefix sum:
            for (int i = 1; i < l; i++) pre[i] = pre[i-1] + g[B[i-1]][B[i]];
            // Floyd Warshall Algorithm
            mk_dp(n, l);

            solve(n, l);
            int ans = cnt == 1? -1: cnt;
            System.out.println(ans);
        }
    }

    public static void solve (int n, int l) {
        int i = 0, k = 0;
        cnt = 0;
        //ArrayList<Integer> a = new ArrayList<>();
        while (i < l-1) {
            k = i+1;
            while (k < l && pre[k] - pre[i] <= dp[B[i]][B[k]]) {k++;}
            cnt += k == l? 2: 1;
            //a.add(B[i]);
            //if (k == l) a.add(B[k-1]);
            if (k == i+1) {cnt = 1; break;} // no sequence can exist
            i = k-1;
        }
        //System.out.println(a);
    }

    // Floyd Warshall Algorithm
    private static void mk_dp(int n, int l) {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (dp[i][k] == Integer.MAX_VALUE || dp[k][j] == Integer.MAX_VALUE) continue;
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                }
            }
        }
    }
}