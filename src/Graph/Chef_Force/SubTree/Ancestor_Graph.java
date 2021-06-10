package Graph.Chef_Force.SubTree;

import java.util.*;
//https://www.codechef.com/problems/TRGRPH

public class Ancestor_Graph {
    static ArrayList<Integer>[] g;
    static int[] par, deg, level, subtree;
    static Set<Integer> visit;
    static boolean isTree;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            int n = scan.nextInt(), m = scan.nextInt(), root = -1;
            init(n);
            while (m-- > 0) addEdge(scan.nextInt(), scan.nextInt());
            for (int i = 1; i <= n; i++) {
                if (deg[i] == n-1) {
                    root = i; break;
                }
            }
            //System.out.println(root);
            if (root == -1) isTree = false;
            else {
                level[0] = -1;
                for (int i = 1; i <= n; i++) {
                    g[i].sort(new Comparator<Integer>() {
                        @Override
                        public int compare(Integer u, Integer v) {
                            return deg[v] - deg[u];
                        }
                    });
                }
                dfs(root, 0);
                if (visit.size() != n) isTree = false;
                else {
                    for (int i = 1; i <= n; i++) {
                        if (subtree[i] - 1 != deg[i] - level[i]) {
                            isTree = false; break;
                        }
                    }
                }
            }
            if(!isTree) System.out.println("NO");
            else {
                System.out.println("YES");
                for (int i = 1; i <= n; i++) System.out.print(par[i] + " ");
                System.out.println();
            }
        }
    }
    static void dfs(int u, int p) {
        visit.add(u);
        par[u] = p; subtree[u] = 1;
        level[u] = level[p] + 1;
        for (int v: g[u]) {
            if (!visit.contains(v)) {
                dfs(v, u);
                subtree[u] += subtree[v];
            }
        }
    }
    static void addEdge(int u, int v) {
        g[u].add(v); g[v].add(u);
        deg[u]++; deg[v]++;
    }
    static void init(int n) {
        g = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) g[i] = new ArrayList<>();
        par = new int[n + 1];
        deg = new int[n + 1];
        visit = new HashSet<>();
        isTree = true;
        subtree = new int[n + 1];
        level = new int[n+1];
    }
}