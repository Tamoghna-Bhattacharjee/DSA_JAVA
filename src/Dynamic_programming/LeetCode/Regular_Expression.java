package Dynamic_programming.LeetCode;

public class Regular_Expression {
    public static void main(String[] args) {
        String s = "aasdfasdfasdfasdfas", p = "aasdf.*asdf.*asdf.*asdf.*s";
//        String s = "aab", p = "c*a*b";
//        String s = "a", p = "a.";
//        String s = "a", p = ".*..";
//        String s = "aaa", p = "aaaa";
//        String s = "xaabyc", p = "xa*b.c";
//        String s = "mississippi", p = "mis*is*p*.";
        byte[][] dp = new byte[s.length()][p.length()];
        for (int i = 0; i < s.length(); i++){
            for (int j = 0; j < p.length(); j++){
                dp[i][j] = -1;
            }
        }
        System.out.println(regex(s, p, s.length() - 1, p.length() - 1, dp) == 1);
//        System.out.println(regex_dp(s, p));
    }

    public static byte regex(String s, String p, int i, int j, byte[][] dp){
        if (i >= 0 && j >= 0 && dp[i][j] != -1)
            return dp[i][j];
        if (i < 0 && j < 0)
            return 1;
        if (j < 0)
            return 0;

        if(p.charAt(j) != '.' && p.charAt(j) != '*'){
            if (i < 0)
                return 0;
            else if (s.charAt(i) != p.charAt(j))
                return 0;
            else
                return dp[i][j] = regex(s, p, i - 1, j - 1, dp);
        }
        if (p.charAt(j) == '.') {
            if (i < 0)
                return 0;

            return dp[i][j] = regex(s, p, i - 1, j - 1, dp);
        }
        if (p.charAt(j) == '*'){
            if (j == 0)
                return 0;

            if (i < 0)
                return regex(s, p, i, j - 2, dp);

            if (s.charAt(i) == p.charAt(j - 1) || p.charAt(j - 1) == '.'){
                return dp[i][j] = (regex(s, p, i - 1, j, dp) == (byte)1 ||
                        regex(s, p, i, j - 2, dp) == (byte)1) ? (byte)1: (byte)0;
            }
            else
                return dp[i][j] = regex(s, p, i, j - 2, dp);
        }
        return 0;
    }

    public static boolean regex_dp(String s, String p){
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for(int j = 0; j < p.length(); j++){
            if (p.charAt(j) == '*')
                dp[0][j + 1] = dp[0][j - 1];
        }

        for (int i = 0; i < s.length(); i++){
            for (int j = 0; j < p.length(); j++){
                if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')
                    dp[i + 1][j + 1] = dp[i][j];
                else if (p.charAt(j) == '*'){
                    dp[i + 1][j + 1] = dp[i + 1][j - 1];
                    if (!dp[i + 1][j + 1]){
                        if (s.charAt(i) == p.charAt(j - 1) || p.charAt(j - 1) == '.')
                            dp[i + 1][j + 1] = dp[i][j + 1];
                    }
                }
            }
        }

        for (int i = 0; i < s.length() + 1; i++) {
            for (int j = 0; j < p.length() + 1; j++) {
                System.out.print(dp[i][j] + "\t");
            }
            System.out.println();
        }
        return dp[s.length()][p.length()];
    }
}
