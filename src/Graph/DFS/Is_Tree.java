package Graph.DFS;

// connected component = 1 and edge = n - 1: tree

import java.util.*;

public class Is_Tree {
    static Map<Integer, Set<Integer>> map = new HashMap<>();
    static Set<Integer> visit = new HashSet<>();
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(), m = scan.nextInt();
        for (int i = 1; i <= n; i++) {
            map.put(i, new HashSet<>());
        }
        for (int i = 1; i <= n; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            map.get(a).add(b); map.get(b).add(a);
        }

        int connected_comp = 0;
        for (int i = 1; i <= n; i++) {
            if (!visit.contains(i)) {
                connected_comp++;
                dfs(i);
            }
            if (connected_comp >= 2) {
                System.out.println("NO");
                return;
            }
        }
        if (connected_comp == 1 && m == n-1)
            System.out.println("YES");
    }
    public static void dfs(int parent) {
        visit.add(parent);
        for (int child: map.get(parent)){
            if (!visit.contains(child))
                dfs(child);
        }
    }
}
