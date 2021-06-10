package Graph.DFS;

import java.util.*;

// Given n, i.e. total number of nodes in an undirected graph numbered from 1 to n and an integer e,
// i.e. total number of edges in the graph. Calculate the total number of connected components in the
// graph. A connected component is a set of vertices in a graph that are linked to each other by
// paths.

public class Connected_Components_in_Graph {
    static Map<Integer, Set<Integer>> map = new HashMap<>();
    static Set<Integer> visit = new HashSet<>();
    public static void main(String args[] ) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(), e = scan.nextInt();
        for (int i = 1; i <= n; i++) {
            map.put(i, new HashSet<>());
        }
        for (int i = 0; i < e; i++) {
            int u = scan.nextInt(), v = scan.nextInt();
            map.get(u).add(v);
            map.get(v).add(u);
        }
        dfs(n);
    }
    public static void dfs(int n) {
        int i = 0;
        for(int node = 1; node <= n; node++){
            if (!visit.contains(node)) {
                i++;
                dfsVisit(node);
            }
        }
        System.out.println(i);
    }

    private static void dfsVisit(int parent) {
        visit.add(parent);
        for (int v: map.get(parent)) {
            if (!visit.contains(v))
                dfsVisit(v);
        }
    }

}
