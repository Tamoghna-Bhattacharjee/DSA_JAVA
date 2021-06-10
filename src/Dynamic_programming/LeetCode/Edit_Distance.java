package Dynamic_programming.LeetCode;

public class Edit_Distance {
    public static void main(String[] args) {
        System.out.println(minDistance("horse", "roe"));
    }
    private static int minDistance(String word1, String word2){
        if (word1.equals(word2)) return 0;
        // matrix - (n X m)
        int n = word1.length(), m = word2.length();
        int[][] dp = new int[n + 1][m + 1];

        // dp(i, j) = in how many ways word1(0, i) is converted to word2(0, j)

        for (int i = 0; i < n + 1; i++) dp[i][0] = i;
        for (int j = 0; j < m + 1; j++) dp[0][j] = j;

        for (int i = 1; i < n + 1; i++){
            for (int j = 1; j < m + 1; j++){
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];
                else
                    dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
            }
        }
        //for (int[] i: dp) System.out.println(Arrays.toString(i));
        return dp[n][m];
    }
}
