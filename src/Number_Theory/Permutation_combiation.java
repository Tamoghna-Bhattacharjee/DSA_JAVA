package Number_Theory;

public class Permutation_combiation {
    static long mod = 1000000007;
    static int maxN = 100000;
    static long[] f1, f2, inv;

    public static void main(String[] args) {

    }
    static long nPr(int n, int r) {
        if (r > n) return 0;
        return f1[n]%mod*f2[n-r]%mod;
    }
    static long nCr(int n, int r) {
        if (r > n) return 0;
        return f1[n]%mod*f2[r]%mod*f2[n-r]%mod;
    }
    static void factorial() {
        f1 = new long[maxN+1]; f2 = new long[maxN+1]; inv = new long[maxN+1];
        inv[1] = 1;
        for (int i = 2; i <= maxN; i++)
            inv[i] = (mod - (mod/i)*inv[(int) mod%i] % mod) % mod;
        f1[0] = f2[0] = 1;
        for (int i = 1; i <= maxN; i++) {
            f1[i] = i*f1[i-1]%mod;
            f2[i] = f2[i-1]%mod*inv[i]%mod;
        }
    }
}
