package Algorithm.BinarySearch.Important;

import java.util.Scanner;

// https://www.geeksforgeeks.org/number-of-ways-to-select-equal-sized-subarrays-from-two-arrays-having-atleast-k-equal-pairs-of-elements/?ref=rp

// Number of ways to select equal sized subarrays from two arrays having atleast K equal
// pairs of elements

public class AtleastK_equalPair_EqualLenSubarrays {
    static int[] a, b;
    static int[][] prefixSum;
    static int n, m, k;
    public static void main(String[] args) {
        init();
        mkPrefixSum();
        // finding smallest sq sub matrix with sum >= k for each (i, j) as bottom right corner
        // making a binary search over size
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int L = 1, R = Math.min(i, j), ind = Integer.MAX_VALUE;
                while (L <= R) {
                    int mid = (L + R) / 2;
                    if (getSum(i, j, mid) >= k) {
                        R = mid-1;
                        ind = Math.min(ind, mid);
                    }
                    else L = mid+1;
                }
                if (ind != Integer.MAX_VALUE && getSum(i, j, ind) >= k) {
                    ans += Math.min(i, j) - ind + 1;
                }
            }
        }
        System.out.println(ans);

    }

    private static void mkPrefixSum() {
        // matching indexes
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                prefixSum[i][j] = a[i] == b[j]? 1: 0;
            }
        }
        // prefix sum
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) prefixSum[i][j] += prefixSum[i][j-1];
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) prefixSum[i][j] += prefixSum[i - 1][j];
        }
    }

    static int getSum(int i, int j, int len) {
        return prefixSum[i][j] - prefixSum[i-len][j] -
                prefixSum[i][j-len] + prefixSum[i-len][j-len];
    }
    static void init() {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt(); m = scan.nextInt();
        a = new int[n+1]; b = new int[m+1];
        for (int i = 1; i <= n; i++) a[i] = scan.nextInt();
        for (int i = 1; i <= m; i++) b[i] = scan.nextInt();
        k = scan.nextInt();
        prefixSum = new int[n+1][m+1];
    }
}
