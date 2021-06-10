package String_algo.Constructive_Problems;

import java.util.Scanner;

public class Anagram_pattern_Search {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String T = scan.nextLine(), P = scan.nextLine();
        System.out.println(isAnagramMatched(T, P));
    }
    static boolean isAnagramMatched(String T, String P) {
        int[] freqP = new int[26], freqT = new int[26];
        int L = 0, R = 0;
        for (int i = 0; i < P.length(); i++) freqP[P.charAt(i)-'a']++;
        while (R < T.length()) {
            char ch = T.charAt(R);
            freqT[ch-'a']++;
            while (freqT[ch-'a'] > freqP[ch-'a']) freqT[T.charAt(L++)-'a']--;
            if (compare(freqP, freqT)) return true;
            R++;
        }
        return false;
    }
    static boolean compare(int[] a, int[] b) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}
