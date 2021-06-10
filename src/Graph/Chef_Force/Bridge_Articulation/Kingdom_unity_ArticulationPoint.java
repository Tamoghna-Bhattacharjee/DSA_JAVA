package Graph.Chef_Force.Bridge_Articulation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
// https://www.codechef.com/problems/KINGCON
public class Kingdom_unity_ArticulationPoint {
    static ArrayList<Integer>[] map;
    static boolean[] visit;
    static Set<Integer> ap;
    static int[] low, in;
    static int time;
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            int n = scan.nextInt(), m = scan.nextInt(), k = scan.nextInt();
            map = new ArrayList[n];
            for (int i = 0; i < n; i++) {
                map[i] = new ArrayList<>();
            }
            while (m-- > 0) {
                int a = scan.nextInt(), b = scan.nextInt();
                map[a].add(b); map[b].add(a);
            }

            low = new int[n]; in = new int[n];
            visit = new boolean[n]; ap = new HashSet<>();
            time = 0;
            dfs(0, -1);
            System.out.println(ap.size() * k);
        }
    }

    public static void dfs (int u, int parent) {
        visit[u] = true;
        low[u] = in[u] = ++time;
        int child = 0;
        for (int v: map[u]) {
            if (v == parent) continue;
            if (visit[v]) {
                // back edge
                low[u] = Math.min(low[u], in[v]);
            }else {
                // forward edge
                child++;
                dfs(v, u);
                low[u]  = Math.min(low[u], low[v]);
                if (parent != -1 && low[v] >= in[u]) ap.add(u); // bridge
            }
        }
        if (parent == -1 && child > 1) ap.add(u);
    }

}

