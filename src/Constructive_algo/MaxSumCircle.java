package Constructive_algo;

import java.util.ArrayList;
import java.util.Scanner;

// https://codeforces.com/contest/1372/problem/D

public class MaxSumCircle {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = scan.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i += 2) list.add(arr[i]);
        for (int i = 1; i < n; i += 2) list.add(arr[i]);
        list.addAll(list);
        long max = Long.MIN_VALUE;
        int L = 0, R = 0;
        long sum = 0;
        for (; R < (n+1)/2; R++) sum += list.get(R);
        max = Math.max(sum, max);
        while (R < list.size()) {
            sum += list.get(R++); sum -= list.get(L++);
            max = Math.max(sum, max);
        }
        System.out.println(max);
    }
}
