package Graph.Spanning_Tree;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Kruskal_algo {
    static Edge[] edges;
    static Comparator<Edge> cmp;
    static int[] dis;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(), m = scan.nextInt();
        dis = new int[n+1]; Arrays.fill(dis, -1);
        edges = new Edge[m];
        for (int i = 0; i < m; i++) {
            int u = scan.nextInt(), v = scan.nextInt(), w = scan.nextInt();
            edges[i] = new Edge(u, v, w);
        }
        cmp = new Comparator<Edge>() {
            @Override
            public int compare(Edge e1, Edge e2) {
                return e1.w - e2.w;
            }
        };
        Arrays.sort(edges, cmp);
        int sum = 0;
        for (Edge e: edges) {
            int u = e.u, v = e.v, w = e.w;
            sum += union(u, v)? w: 0;
        }
        System.out.println(sum);
    }
    static int find (int n) {
        if (dis[n] < 0) return n;
        else return dis[n] = find(dis[n]);
    }
    static boolean union(int a, int b) {
        a = find(a); b = find(b);
        if (a == b) return false;
        if (dis[a] < dis[b]) {
            dis[a] += dis[b];
            dis[b] = a;
        }else {
            dis[b] += dis[a];
            dis[a] = b;
        }
        return true;
    }
    static class Edge {
        int u, v, w;
        public Edge(int u, int v, int w) {
            this.u = u; this.v = v; this.w = w;
        }
    }
}


