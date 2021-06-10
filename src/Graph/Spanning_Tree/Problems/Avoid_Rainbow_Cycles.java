package Graph.Spanning_Tree.Problems;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

// https://codeforces.com/contest/1408/problem/E

public class Avoid_Rainbow_Cycles {
    static long[] a, b;
    static long sum = 0;
    static int[] dis;
    static PriorityQueue<edge> edges;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt(), n = scan.nextInt();
        a = new long[m+1]; b = new long[n+1];
        for (int i = 1; i <= m; i++) a[i] = scan.nextLong();
        for (int i = 1; i <= n; i++) b[i] = scan.nextLong();

        // Maximum spanning tree
        edges = new PriorityQueue<>((e1, e2) -> (int) (e2.w - e1.w));
        dis = new int[m+n+5];
        Arrays.fill(dis, -1);
        for (int i = 1; i <= m; i++) {
            int sz = scan.nextInt();
            for (int j = 1; j <= sz; j++) {
                int num = scan.nextInt();
                edges.add(new edge(i, m + num, a[i] + b[num]));
                sum += a[i] + b[num];
            }
        }

        while (!edges.isEmpty()) {
            edge e = edges.poll();
            if (union(e.u, e.v)) sum -= e.w;
        }
        System.out.println(sum);
    }
    static int find(int x) {
        if (dis[x] < 0) return x;
        else return dis[x] = find(dis[x]);
    }
    static boolean union(int a, int b) {
        a = find(a); b = find(b);
        if (a == b) return false;
        if (dis[a] < dis[b]) {
            dis[a] += dis[b]; dis[b] = a;
        }else {
            dis[b] += dis[a]; dis[a] = b;
        }
        return true;
    }
    static class edge {
        int u, v;
        long w;
        edge(int u, int v, long w) {
            this.u = u; this.v = v;
            this.w = w;
        }
    }
}
