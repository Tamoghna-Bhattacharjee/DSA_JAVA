import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Codechef {
    static int[] sz;
    static long[] dp, F;
    static int n, k, N = 500000;
    static long MOD = 1000000007;
    static ArrayList<Integer>[] g;
    static ArrayList<Integer> centroids;
    static FastReader scan = new FastReader();
    static PrintWriter wr = new PrintWriter(System.out);

    public static void main(String[] args) {
        preprocess();
        int T = scan.nextInt();
        while (T-- > 0) {
            n = scan.nextInt(); k = scan.nextInt();
            init(n);
            for (int i = 0; i < n-1; i++) addEdge(scan.nextInt(), scan.nextInt());
            dfs1(1,0);
            Collections.sort(centroids, (a,b) -> b-a);
            int root = -1;
            if (k == 1) root = centroids.get(0);
            else {
                if (centroids.size() >= 2) root = centroids.get(1);
                else {
                    int max = 0;
                    dfs1(centroids.get(0), 0);
                    for(int v: g[centroids.get(0)]) {
                        if (sz[v] > max) {
                            max = sz[v]; root = v;
                        } else if (sz[v] == max) root = Math.max(root, v);
                    }
                }
            }
            dfs1(root, 0);
            dfs2(root, 0);
            wr.println(root + " " + dp[root]); wr.flush();
        }
    }
    static void dfs2(int u, int p) {
        dp[u] = F[sz[u] - 1] % MOD;
        long denominator = 1, numerator = 1;
        for (int v: g[u]) {
            if (v != p) {
                dfs2(v, u);
                denominator = denominator * F[sz[v]] % MOD;
                numerator = numerator * dp[v] % MOD;
            }
        }
        dp[u] = dp[u] * pow(denominator, MOD-2) % MOD * numerator % MOD;
    }
    static void dfs1(int u, int p) {
        sz[u] = 1;
        boolean isCentroid = true;
        for (int v: g[u]) {
            if (v != p) {
                dfs1(v, u);
                sz[u] += sz[v];
                if (sz[v] > n/2) isCentroid = false;
            }
        }
        if (n - sz[u] > n/2) isCentroid = false;
        if (isCentroid) centroids.add(u);
    }
    static void addEdge(int u, int v) {
        g[u].add(v);
        g[v].add(u);
    }
    static void init(int n) {
        g = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) g[i] = new ArrayList<>();
        sz = new int[n+1];
        dp = new long[n+1];
        centroids = new ArrayList<>();
    }
    static long pow(long a, long x) {
        long res = 1;
        while (x > 0) {
            if (x % 2 == 1) res = res * a % MOD;
            a = a * a % MOD;
            x /= 2;
        }
        return res % MOD;
    }
    static void preprocess() {
        F = new long[N+1];
        F[0] = 1;
        for (int i = 1; i <= N; i++) F[i] = F[i-1] * i % MOD;
    }
}


class FastReader {
    BufferedReader br;
    StringTokenizer st;
    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }
    String next() {
        while (st == null || !st.hasMoreElements()) {
            try{
                st = new StringTokenizer(br.readLine());
            } catch (IOException  e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }
    int nextInt() {
        return Integer.parseInt(next());
    }
    long nextLong() {
        return Long.parseLong(next());
    }
    double nextDouble() {
        return Double.parseDouble(next());
    }
    String nextLine() {
        String str = "";
        try{
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}