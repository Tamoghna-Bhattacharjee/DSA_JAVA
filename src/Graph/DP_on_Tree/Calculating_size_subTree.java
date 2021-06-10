package Graph.DP_on_Tree;

import java.util.*;

public class Calculating_size_subTree {
    static Map<Integer, Set<Integer>> map;
    static Set<Integer> visit;
    static Map<Integer, Integer> size;

    public static void main(String[] args) {
        map = new HashMap<>();
        size = new HashMap<>();
        visit = new HashSet<>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for (int i = 1; i <= n; i++) {
            map.put(i, new HashSet<>()); size.put(i, 0);
        }
        for (int i = 0; i < n-1; i++) {
            int a = scan.nextInt(), b = scan.nextInt();
            map.get(a).add(b); map.get(b).add(a);
        }
        dfs(1);
        System.out.println(size);
    }
    public static int dfs(int parent) {
        visit.add(parent);
        int subsize = 1;
        for (int child: map.get(parent)) {
            if (!visit.contains(child)) {
                subsize += dfs(child);
            }
        }
        size.put(parent, subsize);
        return subsize;
    }
}
