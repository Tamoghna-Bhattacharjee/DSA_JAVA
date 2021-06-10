package Constructive_algo;

import java.util.Scanner;

// https://codeforces.com/contest/1420/problem/C2

public class Pokemon_Army {
    static long[] arr;
    static int n, q;
    static long ans = 0;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            n = scan.nextInt(); q = scan.nextInt();
            arr = new long[n+2];
            arr[0] = arr[n+1] = -1;
            for (int i = 1; i <= n; i++) arr[i] = scan.nextLong();
            ans = 0;
            for (int i = 1; i <= n; i++) {
                if (arr[i] < arr[i-1] && arr[i] < arr[i+1]) ans += -arr[i];
                else if (arr[i] > arr[i-1] && arr[i] > arr[i+1]) ans += arr[i];
            }
            StringBuilder builder = new StringBuilder();
            builder.append(ans).append("\n");
            while (q-- > 0) {
                int L = scan.nextInt(), R = scan.nextInt();
                erase(L-1); erase(L); erase(L+1);
                if (R != L) {
                    if (R-1 != L && R-1 != L+1) erase(R-1);
                    if (R != L+1) erase(R);
                    erase(R+1);
                }
                swap(L, R);
                insert(L-1); insert(L); insert(L+1);
                if (R != L) {
                    if (R-1 != L && R-1 != L+1) insert(R-1);
                    if (R != L+1) insert(R);
                    insert(R+1);
                }
                builder.append(ans).append("\n");
            }
            System.out.print(builder);
        }
    }
    static void swap(int i, int j) {
        long temp = arr[i];
        arr[i] = arr[j]; arr[j] = temp;
    }
    static void erase(int i) {
        if (i == 0 || i == n+1) return;
        if (arr[i] > arr[i-1] && arr[i] > arr[i+1]) ans -= arr[i];
        if (arr[i] < arr[i-1] && arr[i] < arr[i+1]) ans += arr[i];
    }
    static void insert(int i) {
        if (i == 0 || i == n+1) return;
        if (arr[i] < arr[i-1] && arr[i] < arr[i+1]) ans += -arr[i];
        else if (arr[i] > arr[i-1] && arr[i] > arr[i+1]) ans += arr[i];
    }
}
