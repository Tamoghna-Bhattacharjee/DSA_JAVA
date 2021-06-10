package Working_with_Ranges.Segment_Tree;

import java.util.Arrays;
import java.util.Scanner;

public class Range_Minimum_Query_Update {
    static int[] st, arr;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        arr = new int[n+1];
        for (int i = 1; i <= n; i++) arr[i] = scan.nextInt();
        st = new int[4*n+4];
        Arrays.fill(st, Integer.MAX_VALUE);
        buildTree(1, 1, n);
        int Q = scan.nextInt();
        while (Q-- > 0) {
            int x = scan.nextInt() + 1, y = scan.nextInt() + 1;
            System.out.println(quary(1, 1, n, x, y));
        }
    }
    public static void buildTree(int si, int ss, int se) {
        if (ss == se) {
            st[si] = arr[ss]; return;
        }
        int mid = (ss + se) / 2;
        buildTree(2*si, ss, mid);
        buildTree(2*si + 1, mid+1, se);
        st[si] = Math.min(st[2*si], st[2*si+1]);
    }
    public static int quary(int si, int ss, int se, int qs, int qe) {
        if (qs > se || qe < ss) return Integer.MAX_VALUE;
        if (ss >= qs && se <= qe) return st[si];
        int mid = (ss + se) / 2;
        int l = quary(2*si, ss, mid, qs, qe);
        int r = quary(2*si + 1, mid+1, se, qs, qe);
        return Math.min(l, r);
    }

    public static void pointUpdate(int si, int ss, int se, int ui, int val) {
        if (ss == se) {
            arr[ui] = val;
            st[si] = arr[ss]; return;
        }
        int mid = (ss + se) / 2;
        if (ui <= mid) pointUpdate(2*si, ss, mid, ui, val);
        else pointUpdate(2*si + 1, mid+1, se, ui, val);
        st[si] = Math.min(st[2*si], st[2*si+1]);
    }

    // O(n*logn) : not the best method for range update
    // for range update use lazy propagation
    public static void rangeUpdate(long[] st, int si, int ss, int se, int us, int ue, long diff) {
        if (us > se || ue < ss) return;
        if (ss == se) {
            st[si] += diff;
            return;
        }
        int mid = (ss + se) / 2;
        rangeUpdate(st, 2*si, ss, mid, us, ue, diff);
        rangeUpdate(st, 2*si+1, mid+1, se, us, ue, diff);
        st[si] = Math.min(st[2*si], st[2*si+1]);
    }
}
