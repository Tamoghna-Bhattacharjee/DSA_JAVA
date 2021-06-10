package Graph.Chef_Force.Djkstras;

import java.util.*;
// https://www.codechef.com/problems/REVERSE
public class Chef_and_Reversing {
    static ArrayList<Node>[] arr;
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(), m = scan.nextInt();
        arr = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) arr[i] = new ArrayList<Node>();
        while (m-- > 0) {
            int x = scan.nextInt(), y = scan.nextInt();
            arr[x].add(new Node(y, 0));
            arr[y].add(new Node(x, 1));
        }
        Comparator<Node> cmp = new Comparator<Node>() {
            @Override
            public int compare(Node n1, Node n2) {
                return n1.w - n2.w;
            }
        };
        // dijkstra's
        PriorityQueue<Node> pq = new PriorityQueue<>(cmp);
        boolean[] visit = new boolean[n+1];
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        pq.add(new Node(1, 0));
        dist[1] = 0;
        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            int u = curr.v;
            if (!visit[u]) {
                visit[u] = true;
                for (Node child: arr[u]) {
                    dist[child.v] = Math.min(dist[child.v], dist[u] + child.w);
                    pq.add(new Node(child.v, dist[child.v]));
                }
            }
        }
        System.out.println((dist[n] == Integer.MAX_VALUE? -1: dist[n]));
    }
    static class Node {
        int v, w;
        public Node (int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
}
