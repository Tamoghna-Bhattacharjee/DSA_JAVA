package Graph.Chef_Force.SubTree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

// https://codeforces.com/contest/1399/problem/E1

public class Weights_Division1 {
    static ArrayList<edge>[] g;
    static int[] leaves;
    static Comparator<EdgeContri> cmp;
    static PriorityQueue<EdgeContri> pq;
    static long sum;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            int n = scan.nextInt();
            long s = scan.nextLong();
            init(n);
            for (int i = 0; i < n-1; i++)
                addEdge(scan.nextInt(), scan.nextInt(), scan.nextLong());
            dfs1(1, -1);
            dfs2(1, -1);
            int cnt = 0;
            while (sum > s) {
                EdgeContri e = pq.poll();
                sum = sum - e.w * e.f + (e.w/2) * e.f;
                pq.add(new EdgeContri(e.w/2, e.f));
                cnt++;
            }
            System.out.println(cnt);
        }
    }
    static void dfs1(int u, int p) {
        for (edge to: g[u]) {
            if (to.v != p) {
                dfs1(to.v, u);
                leaves[u] += leaves[to.v];
            }
        }
        if (g[u].size() == 1 && p != -1) leaves[u] = 1;
    }
    static void dfs2(int u, int p) {
        for (edge to: g[u]) {
            if (to.v != p) {
                pq.add(new EdgeContri(to.w, leaves[to.v]));
                sum += to.w * leaves[to.v];
                dfs2(to.v, u);
            }
        }
    }
    static void addEdge(int u, int v, long w) {
        g[u].add(new edge(v, w));
        g[v].add(new edge(u, w));
    }
    static void init(int n) {
        g = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) g[i] = new ArrayList<>();
        leaves = new int[n+1];
        cmp = new Comparator<EdgeContri>() {
            @Override
            public int compare(EdgeContri e1, EdgeContri e2) {
                if (e2.diff == e1.diff) return 0;
                return e2.diff > e1.diff? 1: -1;
            }
        };
        pq = new PriorityQueue<>(cmp);
        sum = 0;
    }
    private static class edge {
        int v;
        long w;
        public edge(int v, long w) {
            this.v = v; this.w = w;
        }
    }
    private static class EdgeContri {
        long w, diff;
        int f;
        public EdgeContri(long w, int cnt) {
            this.w = w;
            this.f = cnt;
            this.diff = w*cnt - (w/2)*cnt;
        }
    }
}
