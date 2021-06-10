package Combinatorics;

import java.util.ArrayList;
import java.util.Scanner;

// https://codeforces.com/contest/1326/problem/C

public class Permutation_Partitions {
    static long MOD = 998244353;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt(), k = scan.nextInt();
        ArrayList<Integer> index = new ArrayList<>();
        long sum = 0;
        long permut = 1;

        for (int i = 0; i < n; i++) {
            int x = scan.nextInt();
            if (x >= n-k+1) {
                index.add(i); sum += x;
            }
        }

        for (int i = 1; i < index.size(); i++)
            permut = permut * (index.get(i) - index.get(i-1)) % MOD;

        System.out.println(sum + " " + permut);
    }
}
