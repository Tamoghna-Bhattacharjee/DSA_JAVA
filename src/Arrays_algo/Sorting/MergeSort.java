package Arrays_algo.Sorting;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
    static int[] arr, temp;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        arr = new int[n];
        temp = new int[n];
        for (int i = 0; i < n; i++) arr[i] = scan.nextInt();
        mergeSort(0, n-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void mergeSort(int L, int R) {
        if (R-L+1 <= 1) return;
        int mid = (L + R) / 2;
        mergeSort(L, mid);
        mergeSort(mid+1, R);
        merge(L, mid, R);
    }
    public static void merge(int L, int m, int R) {
        int i = L, j = m+1, k = L;
        while (i <= m && j <= R) {
            if (arr[i] <= arr[j]) temp[k++] = arr[i++];
            else temp[k++] = arr[j++];
        }
        while (i <= m) temp[k++] = arr[i++];
        while (j <= R) temp[k++] = arr[j++];
        for (k = L; k <= R; k++) arr[k] = temp[k];
    }
}
