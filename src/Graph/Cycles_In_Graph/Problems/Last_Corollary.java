package Graph.Cycles_In_Graph.Problems;

import java.util.*;
// https://codeforces.com/contest/1364/problem/D

public class Last_Corollary {
    static ArrayList<Integer>[] g;
    static boolean isCycle;
    static int start, end;
    static int[] color;
    static boolean[] visit;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(), m = scan.nextInt(), k = scan.nextInt();
        init(n);
        for (int i = 0; i < m; i++) addEdge(scan.nextInt(), scan.nextInt());

        dfs(1, 0, 0);
        StringBuilder builder = new StringBuilder();
        if (isCycle) {
            ArrayList<Integer> cycle = getCycle(start, end, n);
            if (cycle.size() <= k) {
                builder.append("2\n").append(cycle.size()).append("\n");
                for (int i: cycle) builder.append(i).append(" ");
            } else {
                builder.append(1).append("\n");
                int limit = (k+1)/2;
                for (int i = 0; i < cycle.size() && limit > 0; i+=2, limit--)
                    builder.append(cycle.get(i)).append(" ");
            }
        } else {
            // graph is a tree and thus should be bipartite
            ArrayList<Integer> white = new ArrayList<>(), black = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                if (color[i] == 0) white.add(i);
                else black.add(i);
            }
            builder.append(1).append("\n");
            int limit = (k+1) / 2;
            if (black.size() > white.size()) {
                for (int i: black) {
                    if (limit > 0) builder.append(i).append(" ");
                    else break;
                    limit--;
                }
            } else {
                for (int i: white) {
                    if (limit > 0) builder.append(i).append(" ");
                    else break;
                    limit--;
                }
            }
        }
        System.out.println(builder);
    }
    static ArrayList<Integer> getCycle(int S, int E, int n) {
        Queue<Integer> q = new LinkedList<>();
        int[] dist = new int[n+1], par = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[S] = 0; par[S] = 0;
        q.add(S);
        boolean done = false;
        while (!q.isEmpty() && !done) {
            int curr = q.poll();
            for (int v: g[curr]) {
                if (curr == S && v == E) continue;
                if (1 + dist[curr] < dist[v]) {
                    par[v] = curr;
                    dist[v] = 1 + dist[curr];
                    if (v == E) {
                        done = true; break;
                    }
                    q.add(v);
                }
            }
        }
        ArrayList<Integer> cycle = new ArrayList<>();
        int curr = E;
        cycle.add(curr);
        while (curr != S) {
            curr = par[curr];
            cycle.add(curr);
        }
        return cycle;
    }
    static void dfs(int u, int p, int c) {
        visit[u] = true;
        color[u] = c;
        for (int v: g[u]) {
            if (v == p) continue;
            if (!visit[v]) dfs(v, u, 1-c);
            else {
                start = u; end = v;
                isCycle = true;
            }
        }
    }
    static void addEdge(int u, int v) {
        g[u].add(v); g[v].add(u);
    }
    static void init(int n) {
        g = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) g[i] = new ArrayList<>();
        isCycle = false;
        start = -1; end = -1;
        color = new int[n+1];
        visit = new boolean[n+1];
    }
}