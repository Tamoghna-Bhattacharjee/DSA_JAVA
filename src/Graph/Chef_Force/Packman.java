package Graph.Chef_Force;

import java.util.Scanner;
// https://www.codechef.com/problems/INF16I
public class Packman {
    static int[] graph;
    static int[] count;
    static int[] us;
    static int min;
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            int n = scan.nextInt(), k = scan.nextInt();
            graph = new int[n+1];
            count = new int[n+1];
            us = new int[k];
            for (int i = 1; i <= n; i++) {
                int x = scan.nextInt(), y = scan.nextInt();
                graph[x] = y;
            }
            for (int i = 1; i <= n; i++) count[i] = scan.nextInt();
            for (int i = 0; i < k; i++) us[i] = scan.nextInt();
            int cnt = 0;
            for (int node: us) {
                min = Integer.MAX_VALUE;
                dfs(node);
                cnt += min == Integer.MAX_VALUE? 0: min;
            }
            System.out.println(cnt);
        }
    }
    public static void dfs (int node) {
        if (node == -1) return;
        min = Math.min(min, count[node]);
        if (min == 0) return;
        dfs(graph[node]);
        count[node] -= min;
    }
}
