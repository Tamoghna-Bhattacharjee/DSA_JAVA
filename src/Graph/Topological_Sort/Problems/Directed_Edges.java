package Graph.Topological_Sort.Problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// https://codeforces.com/contest/1385/problem/E

public class Directed_Edges {
    static ArrayList<Integer>[] g;
    static int[] in;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            int n = scan.nextInt(), m = scan.nextInt();
            ArrayList<Edge> edges = new ArrayList<>();
            init(n);
            for (int i = 0; i < m; i++) {
                int t = scan.nextInt(), x = scan.nextInt(), y = scan.nextInt();
                if (t == 1) {
                    g[x].add(y); in[y]++;
                }
                edges.add(new Edge(x, y));
            }
            ArrayList<Integer> toposort = khan(n);

            if (toposort.size() != n) System.out.println("NO");
            else {
                int[] pos = new int[n+1];
                for (int i = 0; i < toposort.size(); i++)
                    pos[toposort.get(i)] = i;

                StringBuilder builder = new StringBuilder();
                builder.append("YES\n");
                for (Edge e: edges) {
                    int x = e.x, y = e.y;
                    if (pos[x] > pos[y]) builder.append(y + " " + x).append("\n");
                    else builder.append(x + " " + y).append("\n");
                }
                System.out.println(builder);
            }
        }
    }
    static ArrayList<Integer> khan(int n) {
        ArrayList<Integer> res = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (in[i] == 0) q.add(i);
        }
        while (!q.isEmpty()) {
            int curr = q.poll(); res.add(curr);
            for (int v: g[curr]) {
                in[v]--;
                if (in[v] == 0) q.add(v);
            }
        }
        return res;
    }
    static void init(int n) {
        g = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) g[i] = new ArrayList<>();
        in = new int[n+1];
    }
    static class Edge {
        int x, y;
        public Edge(int x, int y) {
            this.x = x; this.y = y;
        }
    }
}