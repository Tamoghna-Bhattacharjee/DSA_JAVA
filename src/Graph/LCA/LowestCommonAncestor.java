package Graph.LCA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
// https://www.codechef.com/LTIME14/problems/TALCA
public class LowestCommonAncestor {
    static int[][] LCA;
    static ArrayList<Integer>[] g;
    static int maxN;
    static int[] level;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        init(n);
        for (int i = 0; i < n-1; i++) addEdge(scan.nextInt(), scan.nextInt());
        dfs(1, 0);
        mkLCA(n);
        int Q = scan.nextInt();
        while (Q-- > 0) {
            int r = scan.nextInt(), u = scan.nextInt(), v = scan.nextInt();
            solve(r, u, v);
        }
    }
    static void solve(int r, int u, int v) {
        int uv = getLCA(u, v), ru = getLCA(r, u), rv = getLCA(r, v);
        int[] candidates = {r, u, v, ru, rv, uv};
        int minD = Integer.MAX_VALUE, actualLCA = 1;
        for (int c: candidates) {
            int d = dist(c, r) + dist(c, u) + dist(c, v);
            if (d < minD) {
                minD = d;
                actualLCA = c;
            }
        }
        System.out.println(actualLCA);
    }
    static int dist(int a, int b) {
        return level[a] + level[b] - 2*level[getLCA(a,b)];
    }
    static int getLCA(int a, int b) {
        if (level[a] > level[b]) {
            a ^= b; b ^= a; a ^= b;
        }
        int d = level[b] - level[a];
        while (d > 0) {
            int i = (int) (Math.log(d) / Math.log(2));
            b = LCA[b][i];
            d -= 1 << i;
        }
        if (a == b) return a;
        for (int i = maxN; i >= 0; i--) {
            if ((LCA[a][i] != -1) && (LCA[a][i] != LCA[b][i])) {
                a = LCA[a][i]; b = LCA[b][i];
            }
        }
        return LCA[a][0];
    }
    static void mkLCA(int n) {
        for (int j = 1; j <= maxN; j++) {
            for (int i = 1; i <= n; i++) {
                if (LCA[i][j-1] != -1)
                    LCA[i][j] = LCA[LCA[i][j-1]][j-1];
            }
        }
    }
    static void dfs(int u, int p) {
        level[u] = level[p] + 1;
        LCA[u][0] = p;
        for (int v: g[u])
            if (v != p)
                dfs(v, u);
    }
    static void addEdge(int u, int v) {
        g[u].add(v); g[v].add(u);
    }
    static void init(int n) {
        maxN = (int) Math.ceil(Math.log(n) / Math.log(2)) + 1;
        LCA = new int[n+1][maxN + 1];
        g = new ArrayList[n+1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(LCA[i], -1);
            g[i] = new ArrayList<>();
        }
        level = new int[n+1]; level[0] = -1;
    }
}

