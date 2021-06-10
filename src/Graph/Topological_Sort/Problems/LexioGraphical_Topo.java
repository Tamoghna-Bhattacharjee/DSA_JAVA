package Graph.Topological_Sort.Problems;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

// https://www.spoj.com/problems/TOPOSORT/

public class LexioGraphical_Topo {
    static ArrayList<Integer>[] g;
    static ArrayList<Integer> res;
    static int[] in;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(), m = scan.nextInt();
        init(n);
        for (int i = 0; i < m; i++) addEdge(scan.nextInt(), scan.nextInt());
        khan(n);
        if (res.size() != n) System.out.println("Sandro fails.");
        else {
            for (int i: res) System.out.print(i + " ");
        }
    }
    static void khan(int n) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i <= n; i++) {
            if (in[i] == 0) pq.add(i);
        }
        while (!pq.isEmpty()) {
            int curr = pq.poll();
            res.add(curr);
            for (int v: g[curr]) {
                in[v]--;
                if (in[v] == 0) pq.add(v);
            }
        }
    }
    static void addEdge(int u, int v) {
        g[u].add(v); in[v]++;
    }
    static void init(int n) {
        g = new ArrayList[n+1];
        res = new ArrayList<>();
        for (int i = 0; i <= n; i++) g[i] = new ArrayList<>();
        in = new int[n+1];
    }
}
