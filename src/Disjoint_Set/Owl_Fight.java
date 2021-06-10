package Disjoint_Set;

import java.util.Scanner;

public class Owl_Fight {
    // https://www.hackerearth.com/practice/data-structures/disjoint-data-strutures/basics-of-disjoint-data-structures/practice-problems/algorithm/owl-fight/

    static int[] parent;
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(), m = scan.nextInt();
        parent = new int[n+1];
        for (int i = 1; i <= n; i++) parent[i] = -i;
        while (m-- > 0) {
            int a = scan.nextInt(), b = scan.nextInt();
            union(a, b);
        }
        //System.out.println(Arrays.toString(parent));
        int Q = scan.nextInt();
        while (Q-- > 0) {
            int u = scan.nextInt(), v = scan.nextInt();
            int x = Math.abs(parent[find(u)]), y = Math.abs(parent[find(v)]);
            if (x == y) System.out.println("TIE");
            else {
                if (x > y) System.out.println(u);
                else System.out.println(v);
            }
        }
    }
    static int find(int node) {
        if (parent[node] < 0) return node;
        return parent[node] = find(parent[node]);
    }
    static void union(int a, int b) {
        a = find(a); b = find(b);
        if (a == b) return;
        parent[a] = Math.min(parent[a], parent[b]);
        parent[b] = a;
    }
}
