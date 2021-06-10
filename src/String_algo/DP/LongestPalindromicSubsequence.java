package String_algo.DP;

import java.util.Scanner;
// Given a string s, find the longest palindromic subsequence's length in s.
public class LongestPalindromicSubsequence {
    static int[][] pal;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt(); scan.nextLine();
        while (T-- > 0) {
            String s = scan.nextLine();
            System.out.println(solve(s));
        }
    }
    public static int solve(String s) {
        int n = s.length();
        pal = new int[n][n];
        return LPS(0, n-1, s);
    }
    public static int LPS(int i, int j, String s) {
        if (i > j) return 0;
        if (i == j) return pal[i][j] = 1;
        if (pal[i][j] != 0) return pal[i][j];
        if (s.charAt(i) == s.charAt(j)) return pal[i][j] = 2 + LPS(i+1, j-1, s);
        return pal[i][j] = Math.max(LPS(i+1, j, s), LPS(i, j-1, s));
    }
}
