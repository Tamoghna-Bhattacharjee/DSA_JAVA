package Dynamic_programming.LeetCode;

public class Decode_Ways_II {
    static int[] dp;
    public static void main(String[] args) {
        System.out.println(numDecodings("*"));
    }
    private static int numDecodings(String s){
        if (s.length() == 0) return 0;
        if (s.charAt(0) == '0') return 0;
        if (s.length() == 1) return s.charAt(0) == '*'? 9: 1;

        dp = new int[s.length()+1];
        return decodeWays(s, 0) % ((int) Math.pow(10, 9) + 7);
    }

    private static int decodeWays(String s, int i) {
        if (dp[i] != 0) return dp[i];
        if (i < s.length() && s.charAt(i) == '0') return 0;
        if (i == s.length() - 1){
            if (s.charAt(i) == '*') return 9;
            else return 1;
        }
        if (i == s.length()) return 1;

        if (s.charAt(i) != '*') {
            if (s.charAt(i + 1) != '*'){
                if (Integer.parseInt(s.substring(i, i + 2)) <= 26)
                    return dp[i] = decodeWays(s, i + 1) + decodeWays(s, i + 2);
                else
                    return dp[i] = decodeWays(s, i + 1);
            }else {
                if (s.charAt(i) == '1')
                    return dp[i] = decodeWays(s, i + 1) + 9 * decodeWays(s, i + 2);
                else if (s.charAt(i) == '2')
                    return dp[i] = decodeWays(s, i + 1) + 6 * decodeWays(s, i + 2);
                else return dp[i] = decodeWays(s, i + 1);
            }
        }else {
            if (s.charAt(i + 1) == '*')
                return dp[i] = 9 * decodeWays(s, i + 1) + 15 * decodeWays(s, i + 2);
            else if (s.charAt(i + 1) <= '6')
                return dp[i] = 9 * decodeWays(s, i + 1) + 2 * decodeWays(s, i + 2);
            else
                return dp[i] = 9 * decodeWays(s, i + 1) + decodeWays(s, i + 2);
        }
    }
}
