package Working_with_Ranges.RangeUpdate_inArray.Chef_Force;

import java.util.Scanner;
// https://codeforces.com/contest/1343/problem/D
public class Constant_Palindrome_Sum {
    static int[] arr, pref, freqSum;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            int n = scan.nextInt(), k = scan.nextInt();
            arr = new int[n+1];
            pref = new int[2*k+5]; // pref[x] = no of pair that sums to x by at-most 1 change
            freqSum = new int[2*k+5]; // freqSum[x] = no of pair that sums to x
            // pref[x] = no. of pair that sum to x by (1 or 0) change
            for (int i = 1; i <= n; i++) arr[i] = scan.nextInt();
            for (int i = 1; i <= n/2; i++) freqSum[arr[i]+arr[n-i+1]]++;
            for (int i = 1; i <= n/2; i++) {
                int min = Math.min(arr[i], arr[n-i+1])+1;
                int max = Math.max(arr[i], arr[n-i+1]) + k;
                update(min, max);
            }
            for (int i = 1; i <= 2*k; i++) pref[i] += pref[i-1];

            int cnt = Integer.MAX_VALUE;
            for (int i = 2; i <= 2*k; i++) {
                cnt = Math.min(cnt, (pref[i] - freqSum[i]) + (n/2 - pref[i])*2);
            }
            System.out.println(cnt);
        }
    }
    static void update(int L, int R) {
        pref[L]++; pref[R+1]--;
    }
}
