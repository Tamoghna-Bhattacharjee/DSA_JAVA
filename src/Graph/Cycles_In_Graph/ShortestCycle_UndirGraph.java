package Graph.Cycles_In_Graph;

import java.util.*;

// https://leetcode.com/problems/shortest-cycle-in-a-graph/

public class ShortestCycle_UndirGraph {

    public static int n, m; // n -> no of nodes, m -> no of edges
    public static ArrayList<Integer>[] g;
    public static Scanner scan;

    public static void main(String[] args) {
        scan = new Scanner(System.in);
        n = scan.nextInt(); m = scan.nextInt();
        init();
        for (int i = 0; i < m; i++) addEdge(scan.nextInt(), scan.nextInt());
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) ans = Math.min(ans, bfs(i));
        System.out.println(ans);
    }

    public static int bfs(int root) {
        int[] d = new int[n+1]; Arrays.fill(d, Integer.MAX_VALUE);
        int[] par = new int[n+1]; Arrays.fill(par, -1);
        Queue<Integer> q = new LinkedList<>();
        int ans = Integer.MAX_VALUE;
        d[root] = 0; q.add(root);
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : g[u]) {
                if (d[v] == Integer.MAX_VALUE) {
                    d[v] = d[u] + 1;
                    par[v] = u;
                    q.add(v);
                } else if (par[v] != u && par[u] != v) ans = Math.min(ans, d[u] + d[v] + 1);
            }
        }
        return ans;
    }

    private static void init() {
        g = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) g[i] = new ArrayList<>();
    }

    public static void addEdge(int u, int v) {
        g[u].add(v); g[v].add(u);
    }

}
