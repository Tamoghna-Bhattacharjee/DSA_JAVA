package Arrays_algo.TwoPointer;
import java.util.Scanner;

// https://codeforces.com/contest/1400/problem/D

public class ZigZag {
    static int[] a;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            int n = scan.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) a[i] = scan.nextInt();
            long ans = 0;
            int[] L = new int[n+1];
            for (int j = 0; j < n; j++) {
                int[] R = new int[n+1];
                for (int k = n-1; k > j; k--) {
                    ans += L[a[k]] * R[a[j]];
                    R[a[k]]++;
                }
                L[a[j]]++;
            }
            System.out.println(ans);
        }
    }
}
