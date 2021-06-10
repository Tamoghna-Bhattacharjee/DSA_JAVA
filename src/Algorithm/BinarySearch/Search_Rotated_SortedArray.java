package Algorithm.BinarySearch;

import java.util.Scanner;

public class Search_Rotated_SortedArray {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = scan.nextInt();
        System.out.println(search(arr, scan.nextInt()));
    }
    public static int search(int[] arr, int target) {
        int pivotInd = getPivot(arr);

        int i1 = searchHalf(arr, target, pivotInd+1, arr.length-1);
        if (i1 != -1) return i1;
        int i2 = searchHalf(arr, target, 0, pivotInd);
        if (i2 != -1) return i2;
        return -1;
    }
    public static int searchHalf(int[] arr, int target, int L, int R) {
        while (L <= R) {
            int mid = (L+R)/2;
            if (arr[mid] == target) return mid;
            if (arr[mid] < target) L = mid+1;
            else R = mid-1;
        }
        return -1;
    }

    public static int getPivot(int[] arr) {
        int L = 0, R = arr.length-1;
        while (L <= R) {
            int mid = (L+R)/2;
            int left = mid-1 >= 0? arr[mid-1]: Integer.MIN_VALUE;
            int right = mid+1 <= arr.length-1?arr[mid+1]: Integer.MIN_VALUE;
            if (arr[mid] > left && arr[mid] > right) return mid;
            else if (arr[L] <= arr[mid]) L = mid+1;
            else R = mid-1;
        }
        return R;
    }
}
