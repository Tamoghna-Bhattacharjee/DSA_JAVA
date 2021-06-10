package Graph.DFS;

import java.util.*;

public class Cycle_detection {
    static Map<Integer, Set<Integer>> map;
    static Set<Integer> visit;

    public static void main(String[] args) {
        map = new HashMap<>();
        visit = new HashSet<>();
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(), edges = scan.nextInt();

        // nodes: 1 to n
        for (int i = 1; i <= n; i++) map.put(i, new HashSet<>());
        for (int e = 0; e < edges; e++) {
            int a = scan.nextInt(), b = scan.nextInt();
            map.get(a).add(b); map.get(b).add(a);
        }
        boolean isCycle = false;
        for (int i = 1; i <= n; i++) {
            if (!visit.contains(i))
                isCycle = dfs(i, -1);
        }

        System.out.println("Cycle" + (isCycle? "": " not") + " present");
    }
    public static boolean dfs(int node, int parent) {
        visit.add(node);
        for (int child: map.get(node)) {
            if (!visit.contains(child))
                if (dfs(child, node)) return true;
            else
                if (child != parent) return true;
        }
        return false;
    }
}
