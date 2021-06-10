package Disjoint_Set;

import java.util.Arrays;
import java.util.Scanner;

public class Basic_find_Union {
    static int[] parent, size;
    // the size array can be removed
    // root will no longer points to itself rather contain the -ve value of the size of graph
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(), m = scan.nextInt();
        parent = new int[n+1]; size = new int[n+1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i; size[i] = 1;
        }
        while (m-- > 0) {
            int u = scan.nextInt(), v = scan.nextInt();
            unioin(u, v);
        }
        System.out.println(Arrays.toString(parent));
        System.out.println(Arrays.toString(size));
    }
    // normal find
    static int find(int n) {
        if (n == parent[n]) return n;
        return find((parent[n]));
    }
    static void unioin(int a, int b) {
        a = find(a); b = find(b);
        if (a == b) return;
        parent[b] = a;
        size[a] += size[b];
    }
    // find with path compression
    static int find_pathCompression(int n) {
        if (n == parent[n]) return n;
        return parent[n] = find_pathCompression(parent[n]);
    }
}
