package Algorithm.BinarySearch.Important;

import java.util.Arrays;
import java.util.Scanner;

// https://codeforces.com/contest/1486/problem/D

public class Max_Median {
    static int n, k;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt(); k = scan.nextInt();
        int[] a = new int[n+1], b = new int[n+1];
        for (int i = 1; i <= n; i++) {
            a[i] = scan.nextInt();
            b[i] = a[i];
        }
        Arrays.sort(b);
        int ans = 0, L = 1, R = n;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (check(a, b[mid])) {
                L = mid+1; ans = Math.max(ans, b[mid]);
            } else R = mid - 1;
        }
        System.out.println(ans);
    }
    static boolean check(int[] a, int median) {
        int[] temp = new int[n+1];
        for (int i = 1; i <= n; i++) {
            if (a[i] >= median) temp[i]++;
            else temp[i]--;
            temp[i] += temp[i - 1];
        }
        int curMin = Integer.MAX_VALUE;
        for (int i = k; i <= n; i++) {
            curMin = Math.min(curMin, temp[i-k]);
            if (temp[i] - curMin > 0) return true;
        }
        return false;
    }
}
