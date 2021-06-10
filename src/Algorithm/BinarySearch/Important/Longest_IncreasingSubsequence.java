package Algorithm.BinarySearch.Important;

import java.util.Arrays;
import java.util.Scanner;
// O(n * log(n))

public class Longest_IncreasingSubsequence {
    static int[] tailTable, parent, arr;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            int n = scan.nextInt();
            arr = new int[n];
            for (int i = 0; i < n; i++) arr[i] = scan.nextInt();
            System.out.println(Arrays.toString(getLIS()));
        }
    }
    static int[] getLIS() {
        int n = arr.length;
        tailTable = new int[n+1]; // store the index of end element of a active list
        parent = new int[n];
        tailTable[0] = Integer.MIN_VALUE;
        tailTable[1] = 0; parent[0] = tailTable[0];
        int len = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] < arr[tailTable[1]]) {
                parent[i] = tailTable[0];
                tailTable[1] = i;
            } else if (arr[i] > arr[tailTable[len]]) {
                parent[i] = tailTable[len];
                tailTable[++len] = i;
            } else {
                int pos = lower_bound(1, len, arr[i]);
                tailTable[pos] = i;
                parent[i] = tailTable[pos-1];
            }
        }

        int[] LIS = new int[len];
        int ind = len-1;
        int k = tailTable[len];
        while (k != Integer.MIN_VALUE) {
            LIS[ind--] = arr[k];
            k = parent[k];
        }
        return LIS;
    }
    static int lower_bound(int L, int R, int x) {
        while (L <= R) {
            int mid = (L + R)/2;
            if (arr[tailTable[mid]] >= x) R = mid-1;
            else L = mid+1;
        }
        return L;
    }
}
