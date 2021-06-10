package Arrays_algo.Window_algo;

// https://codeforces.com/contest/1409/problem/E

import java.util.Arrays;
import java.util.Scanner;

public class Two_Platform {
    static int[] x, y;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            int n = scan.nextInt(), k = scan.nextInt();
            x = new int[n]; y = new int[n];
            for (int i = 0; i < n; i++) x[i] = scan.nextInt();
            for (int i = 0; i < n; i++) y[i] = scan.nextInt();
            Arrays.sort(x);

            // calculating no of points by window method
            int[] left = new int[n], right = new int[n];
            int j = 0;
            for (int i = 0; i < n; i++) {
                while (x[i] - x[j] > k) j++;
                left[i] = i-j+1;
            }
            j = n-1;
            for (int i = n-1; i >= 0; i--) {
                while (x[j] - x[i] > k) j--;
                right[i] = j-i+1;
            }

            // prefix max and suffix max
            for (int i = 1; i < n; i++) left[i] = Math.max(left[i], left[i-1]);
            for (int i = n-2; i >= 0; i--) right[i] = Math.max(right[i], right[i+1]);

            int res = 1;
            for (int i = 0; i < n-1; i++) {
                int a = left[i], b = i+1 < n? right[i+1]: 0;
                res = Math.max(res, a+b);
            }
            System.out.println(res);
        }
    }
}
