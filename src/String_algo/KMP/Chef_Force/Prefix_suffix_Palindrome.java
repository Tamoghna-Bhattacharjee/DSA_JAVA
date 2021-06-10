package String_algo.KMP.Chef_Force;

import java.util.Scanner;

public class Prefix_suffix_Palindrome {
    static int[] LPS;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt(); scan.nextLine();
        while (T-- > 0) {
            String s = scan.nextLine();
            System.out.println(solve(s, s.length()));
        }
    }
    static String solve(String s, int n) {
        int i = 0, j = n-1;
        while (i <= j && s.charAt(i) == s.charAt(j)) {i++; j--;}
        if (i >= j) return s;
        String pref = s.substring(0, i), suf = s.substring(j+1);

        String s1 = s.substring(i, j+1);
        String s2 = (new StringBuilder(s1)).reverse().toString();
        String add1 = getLargestPalindromicPrefix(s1 + "?" + s2);
        String add2 = getLargestPalindromicPrefix(s2 + "?" + s1);
        if (add1.length() > add2.length()) return pref + add1 + suf;
        else return pref + add2 + suf;
    }
    static String getLargestPalindromicPrefix(String s) {
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
