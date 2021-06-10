package Combinatorics;

import java.util.Scanner;
// https://www.codechef.com/problems/RAINBOWB
public class Chef_and_Rainbow {
    static long mod = 1000000007;
    static int maxN = 1000000;
    static long[] f1, f2, inv;
    public static void main (String[] args) throws java.lang.Exception {
        factorial();
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = 0;
        if (n % 2 == 1) k = (n+1)/2;
        else k = n/2;
        System.out.println(nCr(k-1, 7-1)%mod);
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
