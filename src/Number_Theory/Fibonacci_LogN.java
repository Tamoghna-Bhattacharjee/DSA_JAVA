package Number_Theory;

import java.util.Scanner;

public class Fibonacci_LogN {
    static long mod = 1000000007;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            int a = scan.nextInt(), b = scan.nextInt(), n = scan.nextInt();
            System.out.println(getFibo(a, b, n));
        }
    }
    static long getFibo(int a, int b, int n) {
        long[] F = {a, b};
        long[][] Tr = {{0, 1}, {1,1}};
        long[][] P = power(Tr, n);
        long[] res = new long[2];
        res[0] = ((F[0] * P[0][0] % mod) + (F[1] * P[1][0] % mod)) % mod;
        res[1] = ((F[0] * P[0][1] % mod) + (F[1] * P[1][1] % mod)) % mod;
        return res[0];

    }
    static long[][] power(long[][] Tr, int n) {
        long[][] I = {{1,0},{0,1}};
        while (n > 0) {
            if (n % 2 == 1) multiply(I, Tr);
            multiply(Tr, Tr);
            n /= 2;
        }
        return I;
    }
    static void multiply(long[][] A, long[][] B) {
        long[][] res = new long[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++)
                    res[i][j] += A[i][k] * B[k][j] % mod;
            }
        }
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++) A[i][j] = res[i][j] % mod;
    }
}
