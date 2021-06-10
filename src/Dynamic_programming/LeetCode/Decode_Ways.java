package Dynamic_programming.LeetCode;

// https://leetcode.com/problems/decode-ways/

public class Decode_Ways {
    static int[] dp;
    public static void main(String[] args) {
        System.out.println(numDecodings("200"));
    }
    private static int numDecodings(String s) {
        if (s.length() == 0) return 0;
        if (s.charAt(0) == '0') return 0;
        if (s.length() == 1) return 1;
        dp = new int[s.length() + 1];

        return decodeWays_util(s, 0);
    }
    private static int decodeWays_util(String s, int i){
        if (i < s.length() && s.charAt(i) == '0') return 0;
        if (i >= s.length()) return 1;
        if (dp[i] != 0) return dp[i];

        if (i + 1 < s.length() && Integer.parseInt(s.substring(i, i + 2)) <= 26)
            return dp[i] = decodeWays_util(s, i + 1) + decodeWays_util(s, i + 2);
        else
            return dp[i] = decodeWays_util(s, i + 1);
    }
}
