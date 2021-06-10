package Graph.Trie;

// https://codeforces.com/contest/1447/problem/E

import java.util.Scanner;

public class Xor_Tree {
    static int[][] g;
    static int n, nxt;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        g = new int[200000*30][2];
        nxt = 1; // root = 1
        for (int i = 0; i < n; i++) insert(scan.nextInt());
        int ans = n - dfs(1);
        System.out.println(ans);

    }
    static int dfs(int u) {
        if (u == 0) return 0;
        int x = 0, y = 0;
        x = dfs(g[u][0]);
        y = dfs(g[u][1]);
        if (x == 0 && y != 0) return y;
        if (y == 0 && x != 0) return x;
        return Math.max(1+x, 1+y);
    }
    static void insert(int x) {
        int cur = 1;
        for (int i = 30; i >= 0; i--) {
            int bit = (x & (1 << i)) == 0? 0: 1;
            if (g[cur][bit] == 0) g[cur][bit] = ++nxt;
            cur = g[cur][bit];
        }
    }

}
