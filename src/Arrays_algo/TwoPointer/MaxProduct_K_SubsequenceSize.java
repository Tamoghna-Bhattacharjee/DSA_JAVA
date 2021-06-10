package Arrays_algo.TwoPointer;

import java.util.Arrays;
import java.util.Scanner;

// https://www.geeksforgeeks.org/maximum-product-subsequence-size-k/

public class MaxProduct_K_SubsequenceSize {
    static Integer[] a;
    static int n;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            n = scan.nextInt();
            int k = 5;
            a = new Integer[n];
            for (int i = 0; i < n; i++) a[i] = scan.nextInt();
            Arrays.sort(a);
            System.out.println(getMaxProduct(k));
        }
    }

    static long getMaxProduct(int k) {
        long ans = 1;
        if (a[n-1] == 0) {
            if (k % 2 == 1) return 0;
            else {
                for (int i = 0; i < k; i++) ans *= a[i];
            }
        } else if (a[n-1] < 0) {
            if (k % 2 == 1) {
                for (int i = n-1; i >= n-k; i--) ans *= a[i];
            } else {
                for (int i = 0; i < k; i++) ans *= a[i];
            }
        } else {
            int L = 0, R = n-1;
            if (k % 2 == 1) {
                ans *= a[n-1]; R = n-2; k--;
            }
            while (k > 0) {
                if (a[L] * a[L+1] > a[R] * a[R-1]) {
                    ans *= a[L] * a[L+1];
                    L += 2;
                } else {
                    ans *= a[R] * a[R-1];
                    R -= 2;
                }
                k -= 2;
            }
        }
        return ans;
    }

}
