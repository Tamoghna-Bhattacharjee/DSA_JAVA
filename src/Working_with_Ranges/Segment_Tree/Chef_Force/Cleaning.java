package Working_with_Ranges.Segment_Tree.Chef_Force;

import java.util.Scanner;

// https://codeforces.com/contest/1474/problem/D

public class Cleaning {
    static long[][] st, lazy;
    static long INF = 1000_000_000_000L;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            int n = scan.nextInt();
            init(n);
            long[] arr = new long[n+1], B = new long[n+1], C = new long[n+1];
            for (int i = 1; i <= n; i++) arr[i] = scan.nextLong();
            for (int i = 1; i <= n; i++) {
                B[i] = arr[i] - B[i-1];
                C[i] = B[i];
            }

            for (int i = 1; i <= n; i++) {
                if (i % 2 == 0) B[i] = INF;
                else C[i] = INF;
            }

            buildTree(1, 1, n, B, 0);
            buildTree(1, 1, n, C, 1);
            boolean ok = check(n);

            for (int i = 1; i < n && !ok; i++) {
                long x = arr[i+1] - arr[i];
                upd(i, n, x);
                upd(i+1, n, -x);

                ok = check(n);

                upd(i, n, -x);
                upd(i+1, n, x);

            }
            if (ok) System.out.println("YES");
            else System.out.println("NO");
        }
    }
    static void upd(int i, int n, long val) {
        update(1, 1, n, i, n, 1-i%2, val);
        update(1,1,n,i,n,i%2, -val);
    }
    static void test(int n) {
        for (int i = 1; i <= n; i++) {
            System.out.print(query(1,1,n,i,i,0) + " ");
        }
        System.out.println();
        for (int i = 1; i <= n; i++) {
            System.out.print(query(1,1,n,i,i,1) + " ");
        }
        System.out.println();
    }

    static boolean check(int n) {
        if (query(1,1,n, n,n, 1 - n%2) != 0) return false;
        return query(1, 1, n, 1, n, 0) >= 0 &&
                query(1, 1, n, 1, n, 1) >= 0;
    }

    static long query(int si, int ss, int se, int qs, int qe, int type) {
        if (lazy[type][si] != 0) {
            st[type][si] += lazy[type][si];
            if (ss != se) {
                lazy[type][2*si] += lazy[type][si];
                lazy[type][2*si + 1] += lazy[type][si];
            }
            lazy[type][si] = 0;
        }
        if (qs > se || qe < ss || ss > se) return INF;
        if (ss >= qs && se <= qe) return st[type][si];
        int mid = (ss + se) / 2;
        long l = query(2*si, ss, mid, qs, qe, type);
        long r = query(2*si + 1, mid+1, se, qs, qe, type);
        return Math.min(l, r);
    }

    static void update(int si, int ss, int se, int us, int ue, int type, long diff) {
        if (lazy[type][si] != 0) {
            st[type][si] += lazy[type][si];
            if (ss != se) {
                lazy[type][2*si] += lazy[type][si];
                lazy[type][2*si + 1] += lazy[type][si];
            }
            lazy[type][si] = 0;
        }
        if (us > se || ue < ss || ss > se) return;
        if (ss >= us && se <= ue) {
            st[type][si] += diff;
            if (ss != se) {
                lazy[type][2*si] += diff;
                lazy[type][2*si + 1] += diff;
            }
            return;
        }
        int mid = (ss + se) / 2;
        update(2*si, ss, mid, us, ue, type, diff);
        update(2*si+1, mid + 1, se, us, ue, type, diff);
        st[type][si] = Math.min(st[type][2*si], st[type][2*si + 1]);
    }

    static void buildTree(int si, int ss, int se, long[] a, int type) {
        if (ss > se) return;
        if (ss == se) {
            st[type][si] = a[ss]; return;
        }
        int mid = (ss + se) / 2;
        buildTree(2*si, ss, mid, a, type);
        buildTree(2*si + 1, mid+1, se, a, type);
        st[type][si] = Math.min(st[type][2*si], st[type][2*si + 1]);
    }
    static void init(int n) {
        st = new long[2][4*n+4];
        lazy = new long[2][4*n+4];
    }
}
