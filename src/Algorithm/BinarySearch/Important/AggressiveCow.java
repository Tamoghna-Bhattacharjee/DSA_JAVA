package Algorithm.BinarySearch.Important;

import java.util.Arrays;
import java.util.Scanner;
// https://www.spoj.com/problems/AGGRCOW/
public class AggressiveCow {
    static int[] arr;
    public static void main (String[] args) throws java.lang.Exception {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            int n = scan.nextInt(), c = scan.nextInt();
            arr = new int[n+1];
            for (int i = 1; i <= n; i++) arr[i] = scan.nextInt();
            Arrays.sort(arr);
            System.out.println(getMaxofMinDist(n, c));
        }
    }
    static int getMaxofMinDist(int n, int c) {
        // if F(x) -> true then F(x-1) should also be true

        int L = 1, R = (int) Math.ceil(((float) (arr[n]-arr[1])) / c);
        int ans = 1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (isValid(mid, n, c)) {
                ans = Math.max(ans, mid); L = mid+1;
            }else R = mid-1;
        }
        return ans;
    }
    static boolean isValid(int x, int n, int c) {
        int p = arr[1]; c--;
        for (int i = 2; i <= n; i++) {
            if (c <= 0) return true;
            if (arr[i]-p >= x) {
                p = arr[i]; c--;
            }
        }
        return c <= 0;
    }
}