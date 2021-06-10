package Working_with_Ranges.Segment_Tree;
import java.util.*;
// https://www.codechef.com/COOK116B/problems/MAXBTY
public class Lazy_Propagation {
    static long[] st1, st2, lazy1, lazy2, arr, pre;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            int n = scan.nextInt(), Q = scan.nextInt();
            init(n);
            for (int i = 1; i <= n; i++) {
                arr[i] = scan.nextLong();
                pre[i] = pre[i-1] + arr[i];
            }
            mkTree(n);
            scan.nextLine();
            while (Q-- > 0) {
                String str = scan.nextLine();
                String[] s = str.split(" ");
                if (s[0].equals("Q")) {
                    int x = Integer.parseInt(s[1]), y = Integer.parseInt(s[2]);
                    long min = 0, max = 0;
                    if (x - 1 >= 1) min = quaryMin(1, 1, n, 1, x-1);
                    max = quaryMax(1, 1, n, y, n);
                    System.out.println(Math.max(max, max-min));
                }else {
                    int ind = Integer.parseInt(s[1]);
                    long val = Long.parseLong(s[2]);
                    long diff = val - arr[ind];
                    arr[ind] = val;
                    update(n, ind, n, diff);
                }
            }
        }
    }
    public static void mkTree(int n) {
        buildMaxTree(1, 1, n);
        buildMinTree(1, 1, n);
    }
    public static void buildMaxTree(int si, int ss, int se) {
        if (ss > se) return;
        if (ss == se) {
            st1[si] = pre[ss]; return;
        }
        int mid = (ss + se) / 2;
        buildMaxTree(2*si, ss, mid);
        buildMaxTree(2*si+1, mid+1, se);
        st1[si] = Math.max(st1[2*si], st1[2*si+1]);
    }
    public static void buildMinTree(int si, int ss, int se) {
        if (ss > se) return;
        if (ss == se) {
            st2[si] = pre[ss]; return;
        }
        int mid = (ss + se) / 2;
        buildMinTree(2*si, ss, mid);
        buildMinTree(2*si+1, mid+1, se);
        st2[si] = Math.min(st2[2*si], st2[2*si+1]);
    }
    public static long quaryMax(int si, int ss, int se, int qs, int qe) {
        if (lazy1[si] != 0) {
            st1[si] += lazy1[si];
            if (ss != se) {
                lazy1[2*si] += lazy1[si];
                lazy1[2*si+1] += lazy1[si];
            }
            lazy1[si] = 0;
        }
        if (qs > se || qe < ss || ss > se) return Long.MIN_VALUE;
        if (ss >= qs && se <= qe) return st1[si];
        int mid = (ss + se) / 2;
        long l = quaryMax(2*si, ss, mid, qs, qe);
        long r = quaryMax(2*si+1, mid + 1, se, qs, qe);
        return Math.max(l, r);
    }
    public static long quaryMin(int si, int ss, int se, int qs, int qe) {
        if (lazy2[si] != 0) {
            st2[si] += lazy2[si];
            if (ss != se) {
                lazy2[2*si] += lazy2[si];
                lazy2[2*si+1] += lazy2[si];
            }
            lazy2[si] = 0;
        }
        if (qs > se || qe < ss || ss > se) return Long.MAX_VALUE;
        if (ss >= qs && se <= qe) return st2[si];
        int mid = (ss + se) / 2;
        long l = quaryMin(2*si, ss, mid, qs, qe);
        long r = quaryMin(2*si+1, mid + 1, se, qs, qe);
        return Math.min(l, r);
    }

    public static void update(int n, int us, int ue, long diff) {
        updateMax(1, 1, n, us, ue, diff);
        updateMin(1, 1, n, us, ue, diff);
    }
    public static void updateMax(int si, int ss, int se, int us, int ue, long diff) {
        if (lazy1[si] != 0) {
            st1[si] += lazy1[si];
            if (ss != se) {
                lazy1[2*si] += lazy1[si];
                lazy1[2*si+1] += lazy1[si];
            }
            lazy1[si] = 0;
        }
        if (us > se || ue < ss || ss > se) return;
        if (ss >= us && se <= ue) {
            st1[si] += diff;
            if (ss != se) {
                lazy1[2*si] += diff;
                lazy1[2*si+1] += diff;
            }
            return;
        }
        int mid = (ss + se) / 2;
        updateMax(2*si, ss, mid, us, ue, diff);
        updateMax(2*si+1, mid+1, se, us, ue, diff);
        st1[si] = Math.max(st1[2*si], st1[2*si+1]);
    }
    public static void updateMin(int si, int ss, int se, int us, int ue, long diff) {
        if (lazy2[si] != 0) {
            st2[si] += lazy2[si];
            if (ss != se) {
                lazy2[2*si] += lazy2[si];
                lazy2[2*si+1] += lazy2[si];
            }
            lazy2[si] = 0;
        }
        if (us > se || ue < ss || ss > se) return;
        if (ss >= us && se <= ue) {
            st2[si] += diff;
            if (ss != se) {
                lazy2[2*si] += diff;
                lazy2[2*si+1] += diff;
            }
            return;
        }
        int mid = (ss + se) / 2;
        updateMin(2*si, ss, mid, us, ue, diff);
        updateMin(2*si+1, mid+1, se, us, ue, diff);
        st2[si] = Math.min(st2[2*si], st2[2*si+1]);
    }

    public static void init(int n) {
        arr = new long[n+1]; pre = new long[n+1];
        st1 = new long[4*n+4]; st2 = new long[4*n+4];
        lazy1 = new long[4*n+4]; lazy2 = new long[4*n+4];
    }
}
