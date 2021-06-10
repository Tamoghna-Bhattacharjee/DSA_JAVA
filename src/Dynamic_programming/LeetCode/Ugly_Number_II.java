package Dynamic_programming.LeetCode;

import java.util.Arrays;

public class Ugly_Number_II {
    public static void main(String[] args) {
        System.out.println(nthUglyNumber(12));
    }
    private static int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        int factor2 = 2, factor3 = 3, factor5 = 5;
        int i2 = 0, i3 = 0, i5 = 0;
        ugly[0] = 1;
        for (int i = 1; i < n; i++){
            ugly[i] = Math.min(factor2, Math.min(factor3, factor5));

            if (ugly[i] == factor2) factor2 = 2 * ugly[++i2];
            if (ugly[i] == factor3) factor3 = 3 * ugly[++i3];
            if (ugly[i] == factor5) factor5 = 5 * ugly[++i5];
        }
        System.out.println(Arrays.toString(ugly));
        return ugly[n - 1];
    }

}
