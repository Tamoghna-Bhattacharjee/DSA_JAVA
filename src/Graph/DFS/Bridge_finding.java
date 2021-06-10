package Graph.DFS;

import java.util.*;
// https://codeforces.com/contest/118/problem/E
public class Bridge_finding {
    static Map<Integer, Set<Integer>> map;
    static ArrayList<Integer> resu, resv;
    static boolean[] visit;
    static int time;
    static int[] low, in;
    static boolean isbdg;
    public static void main(String[] args) throws java.lang.Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(), m = scan.nextInt();
        map = new HashMap<>();
        for (int i = 1; i <= n; i++) map.put(i, new HashSet<>());
        for (int i = 0; i < m; i++) {
            int a = scan.nextInt(), b = scan.nextInt();
            map.get(a).add(b); map.get(b).add(a);
        }
        low = new int[n+1];
        in = new int[n+1];
        time = 0; isbdg = false;
        visit = new boolean[n+1];
        resu = new ArrayList<>(); resv = new ArrayList<>();
        dfs(1, -1);
        if (isbdg) System.out.println(0);
        else {
            for (int i = 0; i < resu.size(); i++) {
                System.out.println( resu.get(i) + " " + resv.get(i) );
            }
        }
    }
    public static void dfs(int u, int par) {
        visit[u] = true;
        in[u] = low[u] = ++time;
        for (int v: map.get(u)) {
            if (v == par) continue;
            if (visit[v]) {
                // back edge
                low[u] = Math.min(low[u], in[v]);
                if (in[u] > in[v]) {
                    resu.add(u); resv.add(v);
                }
            }else {
                dfs(v, u);
                low[u] = Math.min(low[u], low[v]);
                if (low[v] > in[u]) {
                    // bridge condition
                    isbdg = true; return;
                }
                resu.add(u); resv.add(v);
            }
        }
    }
}
