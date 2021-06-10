package Graph.Chef_Force;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

// https://codeforces.com/contest/1363/problem/C
public class GameOnLeaves {
    static ArrayList<Integer>[] g;
    static int[] level, parent, deg;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            int n = scan.nextInt(), x = scan.nextInt();
            init(n);
            for (int i = 0; i < n-1; i++) addEdge(scan.nextInt(), scan.nextInt());
            level[0] = -1;
            dfs(x, 0);
            boolean[] winner = {true, true};
            int cnt = 0;
            PriorityQueue<Leaf> leaves = new PriorityQueue<>((a, b) -> b.level-a.level);
            for (int i = 1; i <= n; i++) {
                if (g[i].size() == 1) {
                    if (i == x) winner[1] = false;
                    leaves.add(new Leaf(i, level[i]));
                }
                deg[i] = g[i].size();
            }
            while (winner[0] && winner[1] && !leaves.isEmpty()) {
                Leaf curr = leaves.poll();
                deg[curr.node]--; deg[parent[curr.node]]--;
                if (deg[parent[curr.node]] == 1) {
                    leaves.add(new Leaf(parent[curr.node], level[parent[curr.node]]));
                    if (parent[curr.node] == x) winner[cnt % 2] = false;
                }
                cnt++;
            }
            if (winner[0]) System.out.println("Ayush");
            else System.out.println("Ashish");
        }
    }
    static void dfs(int u, int p) {
        level[u] = level[p]+1;
        parent[u] = p;
        for (int v: g[u])
            if (v != p)
                dfs(v, u);
    }
    static void addEdge(int u, int v) {
        g[u].add(v); g[v].add(u);
    }
    static void init(int n) {
        g = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) g[i] = new ArrayList<>();
        level = new int[n+1];
        parent = new int[n+1];
        deg = new int[n+1];
    }
    static class Leaf {
        int node, level;
        public Leaf(int node, int level) {
            this.node = node; this.level = level;
        }
    }
}
