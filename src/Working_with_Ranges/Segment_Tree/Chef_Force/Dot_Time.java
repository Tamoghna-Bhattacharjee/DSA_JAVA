package Working_with_Ranges.Segment_Tree.Chef_Force;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

// https://www.codechef.com/LTIME83B/problems/DOTTIME

public class Dot_Time {
    static long mod = 998244353;
    static long[] arr, pre, s, lazy;
    static long[][] st; // st[i][0] -> sq. sum   and st[i][1] -> sum of ith node
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        PrintWriter wr = new PrintWriter(System.out);
        int T = scan.nextInt();
        while (T-- > 0) {
            int n = scan.nextInt(), m = scan.nextInt(), q = scan.nextInt();
            init(n, m);
            for (int i = 1; i <= n; i++) {
                arr[i] = scan.nextInt();
                pre[i] = (pre[i-1] + arr[i]) % mod;
            }
            int l = 1, r = n-m+1;
            for (int i = 1; i <= m; i++) {
                s[i] = (pre[r] - pre[l-1] + mod) % mod;
                l++; r++;
            }
            buildTree(1, 1, m);
            StringBuilder str = new StringBuilder();
            while (q-- > 0) {
                int id = scan.nextInt(), val = scan.nextInt();
                long diff = (val - arr[id] + mod) % mod;
                arr[id] = val;
                int left = 1, right = m;
                if (id < m) right = id;
                if (id + m - 1 > n) left = m - (n - id);
                update(1, 1, m, left, right, (int) diff);
                str.append(st[1][0]%mod).append("\n");
            }
            wr.print(str);
            wr.flush();
        }
    }
    // sum(Ai + D)^2 over i = sum(Ai^2) over i + 2*sum(Ai)*D over i + sum(D^2) over L to R
    // sum(D^2) over L to R = (L-R+1)*D*D

    static void update(int si, int ss, int se, int us, int ue, int diff) {
        if (us > ue) return;
        if (lazy[si] != 0) {
            st[si][0] = (st[si][0]%mod + 2%mod*st[si][1]%mod*lazy[si]%mod)%mod;
            st[si][0] = (st[si][0]%mod + (se-ss+1)%mod*lazy[si]%mod*lazy[si]%mod)%mod;
            st[si][1] = (st[si][1]%mod + (se-ss+1)%mod*lazy[si]%mod)%mod;
            if (ss != se) {
                lazy[2*si] = (lazy[2*si] + lazy[si]) % mod;
                lazy[2*si+1] = (lazy[2*si+1] + lazy[si]) % mod;
            }
            lazy[si] = 0;
        }
        if (ss > ue || se < us) return;
        if (ss >= us && se <= ue) {
            st[si][0] = (st[si][0]%mod + 2%mod*st[si][1]%mod*diff%mod) % mod;
            st[si][0] = (st[si][0]%mod + (se-ss+1)%mod*diff%mod*diff%mod)%mod;
            st[si][1] = (st[si][1]%mod + (se-ss+1)%mod*diff%mod) % mod;
            if (ss != se) {
                lazy[2*si] = (lazy[2*si] + diff) % mod;
                lazy[2*si+1] = (lazy[2*si+1] + diff) % mod;
            }
            return;
        }
        int mid = (ss + se) / 2;
        update(2*si, ss, mid, us, ue, diff);
        update(2*si+1, mid+1, se, us, ue, diff);
        st[si][0] = (st[2*si][0] + st[2*si+1][0]) % mod;
        st[si][1] = (st[2*si][1] + st[2*si+1][1]) % mod;
    }
    static void buildTree(int si, int ss, int se) {
        if (ss == se) {
            st[si][0] = (s[ss] * s[ss]) % mod;
            st[si][1] = s[ss] % mod;
            return;
        }
        int mid = (ss + se) / 2;
        buildTree(2*si, ss, mid);
        buildTree(2*si+1, mid+1, se);
        st[si][0] = (st[2*si][0] + st[2*si+1][0]) % mod;
        st[si][1] = (st[2*si][1] + st[2*si+1][1]) % mod;
    }
    static void init(int n, int m) {
        arr = new long[n+1]; pre = new long[n+1]; s = new long[m+1];
        st = new long[4*m+4][2];
        lazy = new long[4*m+4];
    }
}
