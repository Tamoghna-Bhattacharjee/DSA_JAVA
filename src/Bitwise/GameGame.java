package Bitwise;

import java.util.Scanner;

// https://codeforces.com/contest/1384/problem/D

public class GameGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            int n = scan.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = scan.nextInt();
            System.out.println(solve(arr, n));
        }
    }
    static String solve(int[] arr, int n) {
        int[][] mask = new int[30][2];
        for (int i: arr) {
            for (int j = 29; j >= 0; j--) {
                int F = power(j);
                if ((i & F) != 0) mask[j][1]++;
                else mask[j][0]++;
            }
        }
        for (int i = 29; i >= 0; i--) {
            int[] f = mask[i];
            if (f[1] % 2 == 0) continue;
            else {
                if (f[1] % 4 == 3 && f[0] % 2 == 0) return "LOSE";
                else return "WIN";
            }
        }
        return "DRAW";
    }
    static int power(int n) {
        int a = 2, res = 1;
        while (n > 0) {
            if (n % 2 == 1) res *= a;
            a *= a;
            n /= 2;
        }
        return res;
    }
}
