package Graph.DFS;

import java.util.ArrayList;
import java.util.Scanner;

public class Kosaraju_SCC {
    static Scanner scan = new Scanner(System.in);
    static ArrayList<Integer>[] g, tg;
    static boolean[] visit;
    static ArrayList<Integer> order, scc;
    static int n, m;
    public static void main(String[] args) {
        init();
        for (int i = 0; i < m; i++) addEdge(scan.nextInt(), scan.nextInt());

        for (int i = 1; i <= n; i++) {
            if (!visit[i]) dfs1(i);
        }
        visit = new boolean[n+1];
        for (int i = order.size()-1; i >= 0; i--) {
            int u = order.get(i);
            if (!visit[u]) {
                scc = new ArrayList<>();
                dfs2(u);
                System.out.println(scc);
            }
        }
    }

    static void dfs1(int u) {
        visit[u] = true;
        for (int v: g[u]) {
            if (!visit[v]) dfs1(v);
        }
        order.add(u);
    }

    static void dfs2(int u) {
        visit[u] = true;
        for (int v: tg[u]) {
            if (!visit[v]) dfs2(v);
        }
        scc.add(u);
    }

    static void addEdge(int u, int v) {
        g[u].add(v); tg[v].add(u);
    }
    static void init() {
        n = scan.nextInt(); m = scan.nextInt();
        g = new ArrayList[n+1]; tg = new ArrayList[n+1];
        visit = new boolean[n+1];
        order = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            g[i] = new ArrayList<>();
            tg[i] = new ArrayList<>();
        }
    }
}
