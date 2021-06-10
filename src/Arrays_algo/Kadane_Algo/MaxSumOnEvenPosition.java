package Arrays_algo.Kadane_Algo;

import java.util.ArrayList;
import java.util.Scanner;

// https://codeforces.com/contest/1373/problem/D

public class MaxSumOnEvenPosition {
    static int[] arr;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            int n = scan.nextInt();
            arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = scan.nextInt();
            long sum = 0;
            for (int i = 0; i < n; i++) {
                if (i % 2 == 0) sum += arr[i];
            }
            ArrayList<Integer> leftShift = new ArrayList<>(), rightShift = new ArrayList<>();
            for (int i = 1; i < n; i+=2) {
                leftShift.add(arr[i]-arr[i-1]);
                if (i+1 < n) rightShift.add(arr[i]-arr[i+1]);
            }
            sum += Math.max(0, Math.max(maxSubArray(leftShift), maxSubArray(rightShift)));
            System.out.println(sum);
        }
    }
    static long maxSubArray(ArrayList<Integer> arr) {
        if (arr.size() == 0) return 0;
        long mxh, msf;
        int n = arr.size();
        msf = mxh = arr.get(0);
        for (int i = 1; i < n; i++) {
            mxh = Math.max(mxh + arr.get(i), arr.get(i));
            msf = Math.max(mxh, msf);
        }
        return msf;
    }
}
