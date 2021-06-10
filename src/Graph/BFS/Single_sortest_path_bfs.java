package Graph.BFS;

import java.util.*;

public class Single_sortest_path_bfs {
    static Map<Integer, Set<Integer>> map;
    static Map<Integer, Integer> dist;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for (int t = 0; t < T; t++) {
            map = new HashMap<>();
            dist = new HashMap<>();
            int n = scan.nextInt(), m = scan.nextInt();
            for (int i = 1; i <= n; i++) map.put(i, new HashSet<>());
            for (int i = 0; i < m; i++) {
                int a = scan.nextInt(), b = scan.nextInt();
                map.get(a).add(b); map.get(b).add(a);
            }
            bfs(1);
            System.out.println(dist.get(n));
        }
    }
    public static void bfs(int node) {
        dist.put(1, 0);
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int child: map.get(curr)) {
                if (!dist.containsKey(child)) {
                    q.add(child);
                    dist.put(child, dist.get(curr) + 1);
                }
            }
        }
    }
}
