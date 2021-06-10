package Constructive_algo;

import java.util.Arrays;
import java.util.Scanner;

// https://leetcode.com/problems/next-greater-element-iii/
public class Next_Permutation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println(nextGreaterElement(scan.nextInt()));
    }
    public static int nextGreaterElement(int n) {
        char[] s = (n+"").toCharArray();
        int i = s.length - 1;
        while (i > 0) {
            if (s[i] > s[i-1]) break;
            i--;
        }
        if (i == 0) return -1;
        Arrays.sort(s, i, s.length);
        char ch = s[i-1];
        for (int j = i; j < s.length; j++) {
            if (s[j] > ch) {
                swap(i-1, j, s);
                break;
            }
        }
        String str = new String(s);
        long res = Long.parseLong(str);
        return res > Integer.MAX_VALUE? -1: (int) res;
    }
    static void swap(int i, int j, char[] s) {
        if (i == j) return;
        s[i] ^= s[j]; s[j] ^= s[i]; s[i] ^= s[j];
    }
}
