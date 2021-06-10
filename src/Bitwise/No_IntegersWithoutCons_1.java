package Bitwise;

import java.util.Scanner;

public class No_IntegersWithoutCons_1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println(findIntegers(scan.nextInt()));
    }
    public static int findIntegers(int num) {
        // dp[i] -> no of binary string of len i without consecutive 1s.
        int[] dp = new int[31];
        dp[0] = 1; dp[1] = 2;
        for (int i = 2; i < 31; i++) dp[i] = dp[i-1] + dp[i-2];

        int prevBit = 0, sum = 0;
        for (int i = 29; i >= 0; i--) {
            if ((num & power(i)) != 0) {
                sum += dp[i];
                if (prevBit == 1) {
                    sum--; break;
                }
                prevBit = 1;
            } else prevBit = 0;
        }
        return sum+1;
    }
    public static int power(int n) {
        int res = 1, a = 2;
        while (n > 0) {
            if (n % 2 == 1) res *= a;
            a *= a;
            n /= 2;
        }
        return res;
    }
}
