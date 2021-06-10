package Algorithm.BinarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

// https://codeforces.com/contest/1379/problem/C

public class Choosing_flowers {
    static Long[] a, pref;
    static ArrayList<pair> p;
    public static void main(String[] args) {
        Scanner scan = new Scanner((System.in));
        int T = scan.nextInt();
        while (T-- > 0) {
            long n = scan.nextLong();
            int m = scan.nextInt();
            a = new Long[m];  p = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                long x = scan.nextLong(), y = scan.nextLong();
                a[i] = x; p.add(new pair(x, y));
            }
            Arrays.sort(a, Collections.reverseOrder());
            pref = new Long[m]; pref[0] = a[0];
            for (int i = 1; i < m; i++) pref[i] = pref[i-1] + a[i];
            long max = 0;
            for (pair i: p) {
                int ind = binarySearch(i.y, m);
                long sum = 0;
                if (ind >= 0) {
                    if (ind + 1 >= n) sum = pref[(int) (n - 1)];
                    else {
                        long k = n - (ind + 1);
                        sum = pref[ind];
                        if (i.x < i.y) sum += i.x + (k - 1) * i.y;
                        else sum += k * i.y;
                    }
                } else {
                    sum = i.x + (n-1)*i.y;
                }
                max = Math.max(max, sum);
            }
            System.out.println(max);
        }
    }
    static int binarySearch(long b, int m) {
        int L = 0, R = m-1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (a[mid] >= b) {
                L = mid+1;
            } else R = mid-1;
        }
        return R;
    }
    static class pair {
        long x, y;
        public pair(long x, long y) {
            this.x = x; this.y = y;
        }
    }
}