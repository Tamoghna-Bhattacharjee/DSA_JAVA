package Number_Theory;

import java.util.Random;
import java.util.Scanner;

public class Fermet_Primality_Test {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            long n = scan.nextLong();
            if (isPrime(n)) System.out.println("YES");
            else System.out.println("NO");
        }
    }
    static boolean isPrime(long p) {
        if (p < 4) return p == 2 || p == 3;
        for (int i = 0; i < 5; i++) {
            long a = 2 + Math.abs((new Random()).nextLong()) % (p-3);
            if (power(a, p-1, p) != 1) return false;
        }
        return true;
    }
    static long power(long a, long n, long mod) {
        long res = 1;
        while (n > 0) {
            if (n % 2 == 1) res = mulmod(res, a, mod);
            a = mulmod(a, a, mod);
            n /= 2;
        }
        return res % mod;
    }
    static long mulmod(long a, long b, long mod) {
        long res = 0; a = a % mod;
        while (b > 0) {
            if (b % 2 == 1) res = (res + a) % mod;
            a = a * 2 % mod;
            b /= 2;
        }
        return res % mod;
    }
}
