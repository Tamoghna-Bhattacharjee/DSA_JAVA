package Working_with_Ranges.Segment_Tree.Chef_Force;

import java.io.PrintWriter;
import java.util.Scanner;

// https://www.codechef.com/problems/MULTQ3
// hello_world10 -> AC  but  tamoghna_99 -> TLE

public class MultipleOf3 {
    static int[][] st; // st[si][i] -> no of elements with ele%3 = i in a range
    static int[] lazy;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt(), Q = scan.nextInt();
        st = new int[4*N+4][3];
        lazy = new int[4*N+4];
        buildTree(1, 1, N);
        StringBuilder builder = new StringBuilder();
        while (Q-- > 0) {
            int ty = scan.nextInt(), a = scan.nextInt()+1, b = scan.nextInt()+1;
            if (ty == 0) update(1, 1, N, a, b);
            else builder.append(query(1, 1, N, a, b)).append("\n");
        }
        PrintWriter wr = new PrintWriter(System.out);
        wr.print(builder);
        wr.flush();
    }
    static void buildTree(int si, int ss, int se) {
        if (ss > se) return;
        if (ss == se) {
            st[si][0]++; return;
        }
        int mid = (ss + se)/2;
        buildTree(2*si, ss, mid);
        buildTree(2*si+1, mid+1, se);
        st[si][0] = st[2*si][0] + st[2*si+1][0];
    }
    static int query(int si, int ss, int se, int qs, int qe) {
        if (qs > qe) return 0;
        if (lazy[si] != 0) {
            for (int i = 0; i < lazy[si]; i++) rightShift(si);
            if (ss != se) {
                lazy[2*si] = (lazy[2*si] + lazy[si]) % 3;
                lazy[2*si+1] = (lazy[2*si+1] + lazy[si]) % 3;
            }
            lazy[si] = 0;
        }
        if (ss > se || qs > se || qe < ss) return 0;
        if (ss >= qs && se <= qe) return st[si][0];
        int mid = (ss + se)/2;
        int l = query(2*si, ss, mid, qs, qe);
        int r = query(2*si+1, mid+1, se, qs, qe);
        return l+r;
    }
    static void update(int si, int ss, int se, int us, int ue) {
        if (us > ue) return;
        if (lazy[si] != 0) {
            for (int i = 0; i < lazy[si]; i++) rightShift(si);
            if (ss != se) {
                lazy[2*si] = (lazy[2*si] + lazy[si]) % 3;
                lazy[2*si+1] = (lazy[2*si+1] + lazy[si]) % 3;
            }
            lazy[si] = 0;
        }
        if (ss > se || us > se || ue < ss) return;
        if (ss >= us && se <= ue) {
            rightShift(si);
            if (ss != se) {
                lazy[2*si] = (lazy[2*si] + 1)%3;
                lazy[2*si+1] = (lazy[2*si+1] + 1)%3;
            }
            return;
        }
        int mid = (ss + se)/2;
        update(2*si, ss, mid, us, ue);
        update(2*si+1, mid+1, se, us, ue);
        st[si][0] = st[2*si][0] + st[2*si+1][0];
        st[si][1] = st[2*si][1] + st[2*si+1][1];
        st[si][2] = st[2*si][2] + st[2*si+1][2];
    }

    static void rightShift(int si) {
        int z = st[si][0], o = st[si][1], t = st[si][2];
        st[si][0] = t; st[si][1] = z; st[si][2] = o;
    }
}
