package Combinatorics;

import java.util.Arrays;
import java.util.Scanner;

// https://codeforces.com/contest/1368/problem/B

public class CodeforceSubsequence {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long k = scan.nextLong(), pdk = 1;
        String s = "codeforces";
        if (k == 1) {
            System.out.println(s); return;
        }
        long[] arr = new long[10];
        Arrays.fill(arr, 1);
        while (pdk < k) {
            for (int i = 0; i < 10 && pdk < k; i++) {
                pdk /= arr[i];
                arr[i]++; pdk *= arr[i];
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < arr[i]; j++) builder.append(s.charAt(i));
        }
        System.out.println(builder);
    }
}
