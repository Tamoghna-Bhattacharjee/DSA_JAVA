package String_algo.DP;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LongestCommonSubstring {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s1 = scan.nextLine(), s2 = scan.nextLine();
        System.out.println(longestCommonSubStr(s1, s2));
    }
    static List<String> longestCommonSubStr (String s1, String s2) {
        int n = s1.length(), m = s2.length();
        int[][] dp = new int[n][m];
        int max = 0;
        List<String> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    if (i == 0 || j == 0) dp[i][j] = 1;
                    else dp[i][j] = 1 + dp[i-1][j-1];
                }
                if (dp[i][j] > max) {
                    max = dp[i][j];
                    res = new ArrayList<>();
                    res.add(s1.substring(i-max+1, i+1));
                }else if (dp[i][j] == max)
                    res.add(s1.substring(i-max+1, i+1));

            }
        }
        return res;
    }
}
