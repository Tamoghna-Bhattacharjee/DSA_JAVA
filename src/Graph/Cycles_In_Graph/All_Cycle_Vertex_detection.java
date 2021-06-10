package Graph.Cycles_In_Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class All_Cycle_Vertex_detection {
    static ArrayList<Integer>[] g;
    static int[] color, par, mark;
    static int cycles;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(), m = scan.nextInt();
        init(n);
        for (int i = 0; i < m; i++) addEdge(scan.nextInt(), scan.nextInt());

        dfs(1, 0);
        Map<Integer, ArrayList<Integer>> cycleList = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            if (mark[i] != 0) {
                if (!cycleList.containsKey(mark[i]))
                    cycleList.put(mark[i], new ArrayList<>());
                cycleList.get(mark[i]).add(i);
            }
        }
        System.out.println(cycleList);
    }
    static void dfs(int u, int p) {
        if (color[u] == 2) return;
        if (color[u] == 1) {
            cycles++;
            int curr = p;
            mark[curr] = cycles;
            while (curr != u) {
                curr = par[curr];
                mark[curr] = cycles;
            }
            return;
        }
        color[u] = 1;
        par[u] = p;
        for (int v: g[u]) {
            if (v != p) dfs(v, u);
        }
        color[u] = 2;
    }
    static void addEdge(int u, int v) {
        g[u].add(v); g[v].add(u);
    }
    static void init(int n) {
        g = new ArrayList[n+1];
        color = new int[n+1];
        par = new int[n+1];
        mark = new int[n+1];
        for (int i = 0; i <= n; i++) g[i] = new ArrayList<>();
        cycles = 0;
    }
}
