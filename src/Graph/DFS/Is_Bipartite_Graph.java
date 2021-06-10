package Graph.DFS;

import java.util.*;

public class Is_Bipartite_Graph {
    static Map<Integer, Set<Integer>> map;
    static Map<Integer, Integer> color;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        for (int t = 1; t <= T; t++) {
            map = new HashMap<>(); color = new HashMap<>();
            int n = scan.nextInt(), edges = scan.nextInt();
            for (int i = 1; i <= n; i++) map.put(i, new HashSet<>());
            for (int e = 0; e < edges; e++) {
                int a = scan.nextInt(), b = scan.nextInt();
                map.get(a).add(b); map.get(b).add(a);
            }
            boolean isbi = false;
            for (int i = 1; i <= n; i++) {
                if (!color.containsKey(i))
                    isbi = dfs(i, 0);
                if (!isbi)
                    break;
            }
            System.out.println("Scenario #" + t + ":");
            if (isbi) System.out.println("No suspicious bugs found!");
            else System.out.println("Suspicious bugs found!");
        }
    }
    public static boolean dfs(int node, int c) {
        color.put(node, c);
        for (int child: map.get(node)) {
            if (!color.containsKey(child)) {
                if (!dfs(child, c ^ 1)) return false;
            }else {
                if (color.get(child) == c) return false;
            }
        }
        return true;
    }
}
