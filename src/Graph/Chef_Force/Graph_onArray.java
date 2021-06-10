package Graph.Chef_Force;

import java.io.*;
import java.util.*;
// https://www.codechef.com/problems/ARRGRAPH

public class Graph_onArray {
    static int[] arr;
    static Set<Integer> visit;
    static ArrayList<Integer>[] g;
    static Set<Integer> gp = new HashSet<>(Arrays.asList(29, 31, 37, 41, 43, 47));

    public static void main (String[] args) throws java.lang.Exception {
        Scanner scan = new Scanner(System.in);
        BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = scan.nextInt();
        while (T-- > 0) {
            int n = scan.nextInt();
            arr = new int[n+1]; g = new ArrayList[n+1];
            boolean is47 = false;
            Set<Integer> set = new HashSet<>();
            for (int i = 1; i <= n; i++) {
                arr[i] = scan.nextInt(); g[i] = new ArrayList<>();
                if (gp.contains(arr[i])) set.add(arr[i]);
                if (arr[i] == 47) is47 = true;
            }
            if (set.size() > 1) print(0, n, wr);
            else {
                mkgraph(n);
                visit = new HashSet<>();
                dfs(1);
                if (visit.size() == n) print(0, n, wr);
                else {
                    arr[1] = is47? 43: 47;
                    print(1, n, wr);
                }
            }
        }
    }
    static void dfs(int u) {
        visit.add(u);
        for (int v: g[u])
            if (!visit.contains(v))
                dfs(v);
    }
    static void mkgraph(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = i+1; j <= n; j++) {
                if (gcd(arr[i], arr[j]) == 1) {
                    g[i].add(j); g[j].add(i);
                }
            }
        }
    }
    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
    public static void print(int cnt, int n, BufferedWriter wr) throws java.lang.Exception {
        wr.write(cnt + "\n");
        for (int i = 1; i <= n; i++) wr.write(arr[i] + " ");
        wr.newLine();
        wr.flush();
    }
}
