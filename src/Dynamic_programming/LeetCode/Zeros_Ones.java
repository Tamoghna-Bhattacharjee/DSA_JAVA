package Dynamic_programming.LeetCode;

import java.util.HashSet;
import java.util.Set;

public class Zeros_Ones {
    static int[] zeros, ones;
    static int[][][] dp;
    public static void main(String[] args) {
        String[] strs = {"0","1101","01","00111","1","10010","0","0","00","1","11","0011"};
        System.out.println(findMaxForm(strs, 63, 36));
    }
    private static int findMaxForm(String[] strs, int m, int n) {
        zeros = new int[strs.length];
        ones = new int[strs.length];
        for (int i = 0; i < strs.length; i++){
            for (char ch: strs[i].toCharArray()){
                if (ch == '0') zeros[i] += 1;
                else ones[i] += 1;
            }
        }
        dp = new int[strs.length + 1][m + 1][n + 1];
        return util(strs, m, n, new HashSet<>());
    }

    private static int util(String[] strs, int m, int n, Set<Integer> used) {
        if (m <= 0 && n <= 0) return 0;
        if (dp[used.size()][m][n] != 0) return dp[used.size()][m][n];
        int max = 0;
        for (int i = 0; i < strs.length; i++) {
            if (!used.contains(i)) {
                if (m - zeros[i] >= 0 && n - ones[i] >= 0) {
                    used.add(i);
                    max = Math.max(max, 1 + util(strs, m - zeros[i], n - ones[i], used));
                    used.remove(i);
                }
            }
        }
        return dp[used.size()][m][n] = max;
    }

}
