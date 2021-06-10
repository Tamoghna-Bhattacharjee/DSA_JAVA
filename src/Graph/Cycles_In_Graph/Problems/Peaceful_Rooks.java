package Graph.Cycles_In_Graph.Problems;

import java.util.ArrayList;
import java.util.Scanner;

// https://codeforces.com/contest/1465/problem/C

public class Peaceful_Rooks {
    static ArrayList<Integer>[] g;
    static int selfLoop;
    static boolean[] visit;
    static boolean isCycle;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        while (t-- > 0) {
            int n = scan.nextInt(), m = scan.nextInt();
            init(n);
            for (int i = 1; i <= m; i++) addEdge(scan.nextInt(), scan.nextInt());
            int cnt_cycle = 0;
            for (int i = 1; i <= n; i++) {
                if (!visit[i]) {
                    isCycle = false;
                    dfs(i, 0);
                    if (isCycle) cnt_cycle++;
                }
            }
            System.out.println(m - selfLoop + cnt_cycle);
        }
    }
    static void dfs(int u, int p) {
        visit[u] = true;
        for (int v: g[u]) {
            if (v == p) continue;
            else if (visit[v]) isCycle = true;
            else dfs(v, u);
        }
    }
    static void addEdge(int u, int v) {
        if (u == v) selfLoop++;
        else {
            g[u].add(v);
            g[v].add(u);
        }
    }
    private static void init(int n) {
        g = new ArrayList[n+1];
        visit = new boolean[n+1];
        for (int i = 0; i <= n; i++) g[i] = new ArrayList<>();
        selfLoop = 0;
        isCycle = false;
    }
}
