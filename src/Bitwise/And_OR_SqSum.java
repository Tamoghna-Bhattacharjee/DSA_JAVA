package Bitwise;

import java.util.Scanner;
// https://codeforces.com/contest/1368/problem/D

public class And_OR_SqSum {
    static int[] arr;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        arr = new int[21];
        for (int i = 0; i < n; i++) setBits(scan.nextInt());
        boolean isOne = true;
        long sum = 0;
        while (isOne) {
            long x = 0;
            isOne = false;
            for (int i = 0; i < 21; i++) {
                if (arr[i] > 0) {
                    x += power2(i); arr[i]--;
                    isOne = true;
                }
            }
            sum += x*x;
        }
        System.out.println(sum);
    }
    static void setBits(int n) {
        int i = 0;
        while (n > 0) {
            if ((n & 1) == 1) arr[i]++;
            n = n >> 1;
            i++;
        }
    }
    static long power2(int n) {
        long res = 1, a = 2;
        while (n > 0) {
            if (n % 2 == 1) res *= a;
            a *= a;
            n /= 2;
        }
        return res;
    }
}
