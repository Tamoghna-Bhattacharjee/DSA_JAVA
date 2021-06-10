package Graph.DFS;

import java.util.*;

public class Single_source_shortest_path {
    static Map<Integer, Integer> dist = new HashMap<>();
    static Map<Integer, Set<Integer>> map = new HashMap<>();
    static Set<Integer> girls = new HashSet<>();

    public static void main(String args[] ) throws Exception {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        for (int i = 1; i <= N; i++) {
            map.put(i, new HashSet<>());
            dist.put(i, Integer.MAX_VALUE);
        }
        dist.put(1, 0);
        for (int i = 0; i < N - 1; i++) {
            int u = scan.nextInt(), v = scan.nextInt();
            map.get(u).add(v); map.get(v).add(u);
        }

        int Q = scan.nextInt();
        for (int i = 0; i < Q; i++) girls.add(scan.nextInt());

        dfs(1);

        int d = Integer.MAX_VALUE, curr=1;
        for (int node: girls) {
            if (dist.get(node) < d) {
                curr = node;
                d = dist.get(node);
            }
        }
        // print the nearest node w.r.t the starting node i.e. 1
        System.out.println(curr);
    }
    public static void dfs(int parent) {
        for (int child: map.get(parent)) {
            if (dist.get(child) > dist.get(parent) + 1) {
                dist.put(child, dist.get(parent) + 1);
                dfs(child);
            }
        }
    }
}
