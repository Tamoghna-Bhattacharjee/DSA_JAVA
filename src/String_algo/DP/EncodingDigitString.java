package String_algo.DP;

import java.util.Scanner;

public class EncodingDigitString {
    static int[] dp;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        System.out.println(bottomUP(s));
        System.out.println(topDown_util(s));
    }
    public static int bottomUP(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        dp = new int[n];
        dp[0] = s.charAt(0) != '0' ? 1 : 0;
        for(int i = 1; i < n; i++) {
            int first = Integer.parseInt(s.substring(i, i+1));
            int second = Integer.parseInt(s.substring(i-1, i+1));
            if(first >= 1 && first <= 9) {
                dp[i] += dp[i-1];
            }
            if(second >= 10 && second <= 26) {
                dp[i] += i >=2 ? dp[i-2] : 1;
            }
        }
        return dp[n-1];
    }


    static int topDown_util(String s) {
        int n = s.length();
        dp = new int[n];
        return topDown(0, s);
    }
    static int topDown(int i, String s) {
        if (i < s.length() && s.charAt(i) == '0') return 0;
        if (i >= s.length()) return 1;
        if (dp[i] != 0) return dp[i];
        if (i + 1 < s.length() && Integer.parseInt(s.substring(i, i + 2)) <= 26)
            return dp[i] = topDown(i+1, s) + topDown(i+2, s);
        return dp[i] = topDown(i+1, s);
    }
}
