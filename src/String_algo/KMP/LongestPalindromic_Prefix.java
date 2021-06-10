package String_algo.KMP;

import java.util.Scanner;

public class LongestPalindromic_Prefix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        String rev = (new StringBuilder(s)).reverse().toString();
        System.out.println(getLongestPalindromicPrefix(s + "?" + rev));
    }
    static String getLongestPalindromicPrefix(String s) {
        int n = s.length();
        int[] LPS = new int[n];
        int j = 0, i = 1;
        while (i < n) {
            if (s.charAt(i) == s.charAt(j)) {
                LPS[i] = j+1;
                j++; i++;
            } else {
                if (j == 0) {
                    LPS[i] = 0; i++;
                }
                else j = LPS[j-1];
            }
        }
        int len = LPS[n-1];
        if (len > 0) return s.substring(0, len);
        else return "";
    }
}
