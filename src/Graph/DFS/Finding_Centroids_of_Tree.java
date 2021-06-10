package Graph.DFS;

import java.util.ArrayList;
import java.util.Scanner;

public class Finding_Centroids_of_Tree {
    static ArrayList<Integer>[] g;
    static int[] subTree;
    static ArrayList<Integer> centroids;
    static int n;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            n = scan.nextInt();
            init();
            for (int i = 0; i < n-1; i++) addEdge(scan.nextInt(), scan.nextInt());
            dfs(1,0);
            System.out.println(centroids);
        }
    }
    static void dfs(int u, int p) {
        subTree[u] = 1;
        boolean isCentroid = true;
        for (int v: g[u]) {
            if (v != p) {
                dfs(v, u);
                subTree[u] += subTree[v];
                if (subTree[v] > n/2) isCentroid = false;
            }
        }
        if (n-subTree[u] > n/2) isCentroid = false;
        if (isCentroid) centroids.add(u);
    }
    static void addEdge(int u, int v) {
        g[u].add(v); g[v].add(u);
    }
    static void init() {
        g = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) g[i] = new ArrayList<>();
        subTree = new int[n+1];
        centroids = new ArrayList<>();
    }
}
