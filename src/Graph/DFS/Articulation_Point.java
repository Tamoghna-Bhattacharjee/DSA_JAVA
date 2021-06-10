package Graph.DFS;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Articulation_Point {
    static ArrayList<Integer>[] graph;
    static boolean[] visit;
    static Set<Integer> ap;
    static int[] low, in;
    static int time;
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            int n = scan.nextInt(), m = scan.nextInt();
            graph = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                graph[i] = new ArrayList<>();
            }
            while (m-- > 0) {
                int a = scan.nextInt()-1, b = scan.nextInt()-1;
                graph[a].add(b); graph[b].add(a);
            }

            low = new int[n]; in = new int[n];
            visit = new boolean[n]; ap = new HashSet<>();
            time = 0;
            for (int i = 0; i < n; i++) {
                if (!visit[i])
                    dfs(0, -1);
            }
            System.out.println(ap);
        }
    }

    public static void dfs (int u, int parent) {
        visit[u] = true;
        low[u] = in[u] = ++time;
        int child = 0;
        for (int v: graph[u]) {
            if (v == parent) continue;
            if (visit[v]) {
                // back edge
                low[u] = Math.min(low[u], in[v]);
            }else {
                // forward edge
                child++;
                dfs(v, u);
                low[u]  = Math.min(low[u], low[v]);
                if (parent != -1 && low[v] >= in[u]) ap.add(u);
            }
        }
        if (parent == -1 && child > 1) ap.add(u); // root with two child
    }
}
