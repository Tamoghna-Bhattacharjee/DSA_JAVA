package Constructive_algo;

import java.util.Scanner;
// https://codeforces.com/contest/1365/problem/B
public class TroubleSort {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            int n = scan.nextInt();
            int[] a = new int[n], b = new int[n], freq = new int[2];
            for (int i = 0; i < n; i++) a[i] = scan.nextInt();
            for (int i = 0; i < n; i++) {
                b[i] = scan.nextInt(); freq[b[i]]++;
            }
            boolean issort = true;
            for (int i = 1; i < n; i++) {
                if (a[i-1] > a[i]) {
                    issort = false; break;
                }
            }
            if (issort) System.out.println("Yes");
            else {
                if (freq[0] == n || freq[1] == n) System.out.println("No");
                else System.out.println("Yes");
            }
        }
    }
}
