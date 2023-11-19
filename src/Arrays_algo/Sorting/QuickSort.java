package Arrays_algo.Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {
    static int[] arr;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = scan.nextInt();
        quickSort(0, n-1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int L, int R) {
        if (L >= R) return;
        int p = getPivot(L, R);
        quickSort(L,p-1);
        quickSort(p+1, R);
    }

    public static int getPivot(int L, int R) {
        int pv = arr[R];
        int idx = L;
        for (int i = L; i < R; i++) {
            if (arr[i] <= pv) {
                swap(idx, i);
                idx++;
            }
        }
        swap(R, idx);
        return idx;
    }
    public static void swap(int i, int j) {
        if (i != j) {
            arr[i] ^= arr[j]; arr[j] ^= arr[i]; arr[i] ^= arr[j];
        }
    }
}
