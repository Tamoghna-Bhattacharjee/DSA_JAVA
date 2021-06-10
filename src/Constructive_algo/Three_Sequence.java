package Constructive_algo;

import java.util.Scanner;

// https://codeforces.com/contest/1406/problem/D

public class Three_Sequence {
    static long[] a, diff;
    static int n;
    static long add_b;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        a = new long[n+5];
        for (int i = 1; i <= n; i++) a[i] = scan.nextLong();

        diff = new long[n+5];
        add_b = 0;
        for (int i = 2; i <= n; i++) {
            diff[i] = a[i] - a[i-1];
            if (diff[i] > 0) add_b += diff[i];
        }
        long a1 = a[1];
        long c1 = (a1 + add_b) / 2;
        long bn = a1 - c1 + add_b;

        System.out.println(Math.max(c1, bn));
        int q = scan.nextInt();
        while (q-- > 0) {
            int l = scan.nextInt(), r = scan.nextInt();
            long x = scan.nextLong();
            if (l == 1) a1 += x;
            else update(l, x);
            update(r+1, -x);

            c1 = (a1 + add_b) / 2;
            bn = a1 - c1 + add_b;
            System.out.println(Math.max(c1, bn));
        }
    }
    static void update(int ind, long x) {
        if (ind > n) return;
        if (diff[ind] > 0) add_b -= diff[ind];
        diff[ind] += x;
        if (diff[ind] > 0) add_b += diff[ind];
    }
}
