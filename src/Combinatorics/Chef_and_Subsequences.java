package Combinatorics;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
// https://www.codechef.com/RC122020/problems/RECNDSUB

/*
   NOTE: (n+m)Cr = nCr*mC0 + nC(r-1)*mC1 + nC(r-2)*mC2 + ... + nC0*mCr   n < r < m
         (n+m)Cm = (n+m)Cn = nC0*mC0 + nC1*mC1 + ... + nCm*mCm  for m <= n
*/

public class Chef_and_Subsequences {
    static long mod = 163577857;
    static int maxN = 100000;
    static long[] f1, f2, inv;
    public static void main(String[] args) throws IOException {
        factorial();
        Scanner scan = new Scanner(System.in);
        PrintWriter wr = new PrintWriter(System.out);
        int T = scan.nextInt();
        while (T-- > 0) {
            int n = scan.nextInt();
            Map<Integer, Integer> map = new HashMap<>();
            map.put(-1,0); map.put(1, 0); map.put(0, 0);
            for (int i = 0; i < n; i++) {
                int a = scan.nextInt();
                map.put(a, map.get(a) + 1);
            }
            long p = power(2, map.get(0))%mod;
            // for -ve
            StringBuilder str = new StringBuilder();
            for (int i = -n; i < 0; i++) {
                int s = Math.abs(i);
                if (s > map.get(-1)) str.append(0).append(" ");
                else {
                    int take = map.get(-1) - s;
                    str.append(p * nCr(map.get(-1) + map.get(1), take) % mod).append(" ");
                }
            }
            // for 0
            str.append((p*nCr(map.get(1) + map.get(-1), map.get(1)) - 1 + mod)%mod ).append(" ");
            // for +ve
            for (int i = 1; i <= n; i++) {
                int s = i;
                if (s > map.get(1)) str.append(0).append(" ");
                else {
                    int take = map.get(1) - s;
                    str.append(p * nCr(map.get(-1) + map.get(1), take) % mod).append(" ");
                }
            }
            wr.println(str);
            wr.flush();
        }
    }
    static long power(long a, int n) {
        long res = 1;
        while (n > 0) {
            if (n % 2 == 1) res = res * a % mod;
            a = a * a % mod;
            n /= 2;
        }
        return res%mod;
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
