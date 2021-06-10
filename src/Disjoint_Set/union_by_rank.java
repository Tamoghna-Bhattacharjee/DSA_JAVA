package Disjoint_Set;

import java.util.Arrays;
import java.util.Scanner;

public class union_by_rank {
    static int[] parent, size;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(), m = scan.nextInt();
        for (int i = 1; i <= n; i++) {
            parent[i] = -1; size[i] = 1;
        }
        while (m-- > 0) {
            int a = scan.nextInt(), b = scan.nextInt();
            union_byRank(a, b);
        }
        System.out.println(Arrays.toString(parent));
        System.out.println(Arrays.toString(size));
    }
    static int find(int n) {
        if (parent[n] < 0) return n;
        return find(parent[n]);
    }
    static void union_byRank(int a, int b) {
        a = find(a); b = find(b);
        if (a == b) return;
        if (size[a] > size[b]) {
            // add b to a
            size[a] += size[b];
            parent[b] = a;
        }else {
            // add a to b
            size[b] += size[a];
            parent[a] = b;
        }
    }
}
