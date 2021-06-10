package Combinatorics;

import java.io.PrintWriter;
import java.util.Scanner;
// https://www.codechef.com/problems/CODEKARO
public class Palindrome_combinatorics {
    static long mod = 1000000007;
    public static void main (String[] args) throws java.lang.Exception {
        Scanner scan = new Scanner(System.in);
        PrintWriter wr = new PrintWriter(System.out);
        int T = scan.nextInt();
        while (T-- > 0) {
            int n = scan.nextInt(), k = scan.nextInt();
            for (int i = 0; i < n; i++) {
                int L = scan.nextInt();
                long Q = power(52, L)%mod;
                Q = power(Q, mod-2);
                long P = power(52 + 2 * k, L/2) % mod;
                if (L % 2 == 1) P = (52*P)%mod;
                long res = ((P%mod) * (Q%mod))%mod;
                wr.println(res);
                wr.flush();
            }
        }
    }
    static long power(long a, long n) {
        long res = 1;
        while (n > 0) {
            if (n % 2 == 1) res = res * a % mod;
            a = a * a % mod;
            n /= 2;
        }
        return res%mod;
    }
}
