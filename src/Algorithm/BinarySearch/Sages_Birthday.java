package Algorithm.BinarySearch;

import java.util.Arrays;
import java.util.Scanner;

// https://codeforces.com/contest/1419/problem/D2

public class Sages_Birthday {
    static int[] arr;
    static int n;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        arr = new int[n];
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) arr[i] = scan.nextInt();
        Arrays.sort(arr);
        int L = 0, R = n, cnt = 0;
        while (L <= R) {
            int mid = (L + R) / 2;
            int[] temp = check(mid);
            if (temp != null) {
                ans = Arrays.copyOf(temp, n);
                cnt = mid;
                L = mid + 1;
            } else R = mid - 1;
        }
        System.out.println(cnt);
        for (int i: ans) System.out.print(i + " ");

    }
    static int[] check(int x) {
        // taking x small no and x+1 large number

        if (2*x + 1 > n) return null;
        int[] res = new int[n];
        int small = 0, large = n-(x+1);
        for (int i = 0; i < 2*x+1; i++) {
            if (i % 2 == 0) res[i] = arr[large++];
            else res[i] = arr[small++];
        }
        for (int i = 2*x+1; small < n-(x+1); i++) res[i] = arr[small++];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (i-1 >= 0 && i+1 < n) {
                if (res[i] < res[i-1] && res[i] < res[i+1]) cnt++;
            }
        }
        if (cnt >= x) return res;
        else return null;
    }
}
