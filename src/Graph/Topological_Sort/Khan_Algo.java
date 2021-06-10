package Graph.Topological_Sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Khan_Algo {
    static ArrayList<Integer>[] g;
    static ArrayList<Integer> res;
    static int[] in;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(), m = scan.nextInt();
        init(n);
        for (int i = 0; i < m; i++) addEdge(scan.nextInt(), scan.nextInt());
        khan(n);
    }
    static void khan(int n) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++)
            if (in[i] == 0) q.add(i);
        while (!q.isEmpty()) {
            int curr = q.poll();
            res.add(curr);
            for (int v: g[curr]) {
                in[v]--;
                if (in[v] == 0) q.add(v);
            }
        }
        System.out.println("Topological Sort:");
        System.out.println(res);
    }
    static void addEdge(int u, int v) {
        g[u].add(v);
        in[v]++;
    }
    static void init (int n) {
        g = new ArrayList[n+1];
        in = new int[n+1];
        res = new ArrayList<>();
        for (int i = 0; i <= n; i++) g[i] = new ArrayList<>();
    }
}
