package Dynamic_programming.Digit_DP;

import java.util.Arrays;
import java.util.Scanner;

public class DigitSum_in_Range {
    static String L, R;
    static int[] arr;
    static long[][][] dp;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt(); scan.nextLine();
        while (T-- > 0) {
            L = scan.nextLine(); R = scan.nextLine();
            long x = util(L), y = util(R);
            long ans = y - x + digitSum(L);
            System.out.println(ans);
        }
    }
    static long util(String s) {
        // return digit sum from 1 to s;
        int n = s.length();
        dp = new long[n+5][9*n+9][2];
        for (long[][] i: dp) {
            for (long[] j : i) Arrays.fill(j, -1);
        }
        mkArr(s, n);
        return getSum(1, n, 0, 0);
    }
    static void mkArr(String s, int n) {
        arr = new int[n+1];
        for (int i = 0; i < n; i++) arr[i+1] = s.charAt(i) - '0';
    }
    static long getSum(int pos, int n, int sum, int flag) {
        if (pos > n) return sum;
        if (dp[pos][sum][flag] != -1) return dp[pos][sum][flag];
        int limit = 9;
        if (flag == 0) limit = arr[pos];
        long res = 0;
        for (int i = 0; i <= limit; i++) {
            if (flag == 1 || i < limit) res += getSum(pos+1, n, sum+i, 1);
            else res += getSum(pos+1, n, sum+i, 0);
        }
        return dp[pos][sum][flag] = res;
    }
    static long digitSum(String s) {
        long res = 0;
        for (int i = 0; i < s.length(); i++) res += s.charAt(i) - '0';
        return res;
    }
}
