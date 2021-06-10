package Working_with_Ranges.Segment_Tree.Chef_Force;
import java.util.Scanner;
//https://www.codechef.com/problems/RANPRO

public class Perfect_product {
    static int[][] st;
    static int maxN = 1000000;
    static int[] spf = new int[maxN + 1], arr;
    public static void main(String[] args) {
        sieve();
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        arr = new int[n+1];
        st = new int[4*n+4][101];
        for (int i = 1; i <= n; i++) arr[i] = scan.nextInt();
        buildTree(1, 1, n);
        int q = scan.nextInt();
        while(q-- > 0) {
            int k = scan.nextInt(), a = scan.nextInt(), b = scan.nextInt();
            if (k == 1) {
                int[] res = quary(1, 1, n, a, b);
                //System.out.println(Arrays.toString(res));
                boolean isperfect = true;
                for (int i = 2; i < 101; i++) {
                    if (res[i] % 2 == 1 ){
                        isperfect = false; break;
                    }
                }
                System.out.println((isperfect? "YES": "NO"));
            }else {
                update(1, 1, n, a, b);
            }
        }

    }
    static void update(int si, int ss, int se, int ui, int val) {
        if (ss == se) {
            int[] a = primeFactor(val);
            for (int i = 2; i < 101; i++) st[si][i] += a[i]; return;
        }
        int mid = (ss + se) / 2;
        if (ui <= mid) update(2*si, ss, mid, ui, val);
        else update(2*si+1, mid+1, se, ui, val);
        for (int i = 2; i < 101; i++)
            st[si][i] = st[2*si][i] + st[2*si+1][i];
    }

    static int[] quary(int si, int ss, int se, int qs, int qe) {
        if (qs > se || qe < ss) return new int[101];
        if (ss >= qs && se <= qe) {
            return st[si];
        }
        int mid = (ss + se) / 2;
        int[] left = quary(2*si, ss, mid, qs, qe);
        int[] right = quary(2*si + 1, mid+1, se, qs, qe);
        int[] res = new int[101];
        for (int i = 2; i < 101; i++) res[i] = left[i] + right[i];
        return res;
    }

    static void buildTree(int si, int ss, int se) {
        if (ss == se) {
            st[si] = primeFactor(arr[ss]); return;
        }
        int mid = (ss + se) / 2;
        buildTree(2*si, ss, mid);
        buildTree(2*si+1, mid+1, se);
        for (int i = 2; i < 101; i++)
            st[si][i] = st[2*si][i] + st[2*si+1][i];
    }
    static int[] primeFactor(int n) {
        int[] res = new int[101];
        while (n > 1) {
            res[spf[n]]++;
            n /= spf[n];
        }
        return res;
    }
    static void sieve() {
        for (int i = 2; i <= maxN; i++) spf[i] = i;
        for (int i = 2; i <= maxN; i+=2) spf[i] = 2;
        for (int i = 3; i*i <= maxN; i++) {
            if (spf[i] == i) {
                for (int j = i; i*j <= maxN; j+=2) {
                    if (spf[i*j] == i*j) spf[i*j] = i;
                }
            }
        }
    }
}
