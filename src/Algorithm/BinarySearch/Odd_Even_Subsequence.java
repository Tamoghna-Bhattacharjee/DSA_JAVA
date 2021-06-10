package Algorithm.BinarySearch;

import java.util.ArrayList;
import java.util.Scanner;

// https://codeforces.com/contest/1370/problem/D

// min(max ele of even index, max ele of odd index) <= x
// iff we have a subsequence
//                      either with max ele at even index <= x or
//                             with max ele at odd index <= x


public class Odd_Even_Subsequence {
    static int[] arr;
    static int n, k;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt(); k = scan.nextInt();
        arr = new int[n];
        int L = 1, R = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
            R = Math.max(R, arr[i]);
        }
        int ans = R;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (isOddSeq(mid) || isEvenSeq(mid)) {
                R = mid-1; ans = Math.min(ans, mid);
            }
            else L = mid+1;
        }
        System.out.println(ans);
    }
    static boolean isOddSeq(int x) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (res.size() % 2 == 0) res.add(arr[i]);
            else if (arr[i] <= x) res.add(arr[i]);
        }
        return res.size() >= k;
    }
    static boolean isEvenSeq(int x) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (res.size() % 2 == 1) res.add(arr[i]);
            else if (arr[i] <= x) res.add(arr[i]);
        }
        return res.size() >= k;
    }
}
