package Graph.BFS;

import java.util.*;

// given a map and m quarries
// in each quarry you are given root node and a distance d
// you need to calculate the no. of nodes at a distance d from the root node

public class Social_Network {
    static Map<Integer, Set<Integer>> map;
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);

        map = new HashMap<>();
        int n = scan.nextInt(), e = scan.nextInt();
        for (int i = 0; i <= n; i++) map.put(i, new HashSet<>());
        for (int i = 0; i < e; i++) {
            int u = scan.nextInt(), v = scan.nextInt();
            map.get(u).add(v);
            map.get(v).add(u);
        }
        int m = scan.nextInt();
        for (int i = 0; i < m; i++) {
            int root = scan.nextInt(), dist = scan.nextInt();
            System.out.println(bfs(root, dist));
        }

    }
    public static int bfs(int root, int d) {
        if (d == 0) return 1;
        Queue<Integer> q = new LinkedList<>();
        Map<Integer, Integer> dist = new HashMap<>();
        q.add(root); dist.put(root, 0);
        int cnt = 0;
        while (!q.isEmpty()) {
            int curr = q.poll();
            if (dist.get(curr) >= d) break;
            for (int child: map.get(curr)) {
                if (!dist.containsKey(child)) {
                    if (dist.get(curr) + 1 == d) cnt++;
                    dist.put(child, dist.get(curr) + 1); q.add(child);
                }
            }
        }
        return cnt;
    }
}
