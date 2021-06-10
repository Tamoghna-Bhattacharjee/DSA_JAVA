package Graph.DFS;

import java.util.*;
// hint: bipartite graph

public class Feasable_Relations {
    static Map<Integer, Set<Integer>> map;
    static Set<Integer> visit;
    static int[] cc;
    static int curr_comp;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            int n = scan.nextInt(), k = scan.nextInt(); scan.nextLine();

            map = new HashMap<>();
            visit = new HashSet<>();
            cc = new int[n+1];
            curr_comp = 0;
            for (int i = 1; i <= n; i++) map.put(i, new HashSet<>());
            ArrayList<int[]> arr = new ArrayList<>();

            for (int i = 0; i < k; i++) {
                String str = scan.nextLine();
                String[] s = str.split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[2]);
                if (s[1].length() == 1) {
                    map.get(a).add(b); map.get(b).add(a);
                }else {
                    int[] x = {a, b};
                    arr.add(x);
                }
            }
            for (int i = 1; i <= n; i++) {
                if (!visit.contains(i)) {
                    curr_comp++;
                    dfs(i);
                }
            }

            boolean flag = true;
            for (int[] i: arr) {
                if (cc[i[0]] == cc[i[1]]) {
                    flag = false;
                    break;
                }
            }
            System.out.println((flag? "YES": "NO"));
        }
    }
    public static void dfs(int node) {
        visit.add(node);
        cc[node] = curr_comp;
        for (int child: map.get(node)) {
            if (!visit.contains(child))
                dfs(child);
        }
    }
}
