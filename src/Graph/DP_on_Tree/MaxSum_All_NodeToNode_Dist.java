package Graph.DP_on_Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// https://codeforces.com/contest/1401/problem/D

public class MaxSum_All_NodeToNode_Dist {
    static ArrayList<Integer>[] g;
    static ArrayList<Edge> edges;
    static long[] subTree;
    static long MOD = 1000000007;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            int n = scan.nextInt();
            init(n);
            for (int i = 0; i < n-1; i++) addEdge(scan.nextInt(), scan.nextInt());

            // calculating how many times a edge is used for all node to node connection
            dfs(1, 0);
            long[] usage = new long[n-1]; int ind = 0;
            //for (int i = 2; i <= n; i++) usage[ind++] = subTree[i] * (n - subTree[i]);
            for (Edge e: edges) {
                long c1 = Math.min(subTree[e.u], subTree[e.v]);
                long c2 = n-c1;
                usage[ind++] = c1 * c2;
            }
            Arrays.sort(usage);

            // setting weights
            int m = scan.nextInt();
            ArrayList<Long> primes = new ArrayList<>();
            for (int i = 0; i < m; i++) primes.add(scan.nextLong());
            for (int i = m; i < n-1; i++) primes.add((long) 1);
            primes.sort((a,b) -> (int) (a-b));
            for (int i = m; i >  n-1; i--) {
                long p1 = primes.get(primes.size() - 1);
                primes.remove(primes.size() - 1);
                long p2 = primes.get(primes.size() - 1);
                primes.remove(primes.size() - 1);
                primes.add(p1 * p2 % MOD);
            }

            // sum of weight for all node to node traversal
            long ans = 0;
            for (int i = 0; i < n-1; i++) {
                ans += (usage[i] * primes.get(i)) % MOD;
                ans = ans % MOD;
            }
            System.out.println(ans);
        }
    }
    static void dfs(int u, int p) {
        subTree[u] = 1;
        for (int v: g[u]) {
            if (v != p) {
                dfs(v, u);
                subTree[u] += subTree[v];
            }
        }
    }
    static void addEdge (int u, int v) {
        edges.add(new Edge(u, v));
        g[u].add(v); g[v].add(u);
    }
    static void init(int n) {
        g = new ArrayList[n+1];
        edges = new ArrayList<>();
        for (int i = 0; i <= n; i++) g[i] = new ArrayList<>();
        subTree = new long[n+1];
    }
    static class Edge {
        int u, v;
        Edge(int u, int v) {
            this.u = u; this.v = v;
        }
    }
}
