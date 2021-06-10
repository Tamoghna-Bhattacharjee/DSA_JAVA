package Graph.DFS;

import java.util.*;

public class Diameter_of_Tree {
    static Map<Integer, Set<Integer>> tree;
    static Set<Integer> visit;
    static int maxDist, endNode;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        tree = new HashMap<>();
        int n = scan.nextInt();
        for (int i = 1; i <= n; i++) tree.put(i, new HashSet<>());

        for (int i = 0; i < n - 1; i++) {
            int a = scan.nextInt(), b = scan.nextInt();
            tree.get(a).add(b); tree.get(b).add(a);
        }

        maxDist = -1; endNode = -1;
        visit = new HashSet<>();
        dfs(1, 0);


        maxDist = -1;
        visit = new HashSet<>();
        dfs(endNode, 0);
        System.out.println(maxDist);
    }

    public static void dfs(int parent, int d) {
        visit.add(parent);
        if (d > maxDist) {
            maxDist = d; endNode = parent;
        }
        for (int child: tree.get(parent)) {
            if (!visit.contains(child))
                dfs (child, d+1);
        }
    }
}
