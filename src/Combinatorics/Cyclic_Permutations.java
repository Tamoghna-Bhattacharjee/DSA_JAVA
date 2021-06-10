package Combinatorics;

import java.util.Scanner;
// https://codeforces.com/contest/1391/problem/C

public class Cyclic_Permutations {
    static long mod = 1000000007;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        long f = 1;
        for (int i = 1; i <= n; i++) f = f * i % mod;
        long ans = (mod + f - power(2, n-1)) % mod;
        System.out.println(ans);
    }
    static long power(long a, int n) {
        long res = 1;
        while (n > 0) {
            if (n % 2 == 1) res = res * a % mod;
            a = a * a % mod;
            n /= 2;
        }
        return res % mod;
    }
}
