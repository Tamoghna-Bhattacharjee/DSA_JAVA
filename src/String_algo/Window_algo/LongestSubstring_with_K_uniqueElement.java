package String_algo.Window_algo;

import java.util.Scanner;

public class LongestSubstring_with_K_uniqueElement {
    static int max, start, end;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        int k = scan.nextInt();
        max = 0; start = -1; end = -1;
        getLongestSubstring(s, k);
        System.out.println(s.substring(start, end+1));
    }
    static void getLongestSubstring (String s, int k) {
        int L = 0, R = 0;
        int[] freq = new int[26];
        int uniqueElement = 0;
        while (R < s.length()) {
            char ch = s.charAt(R);
            freq[ch-'a']++;
            if (freq[ch-'a'] == 1) uniqueElement++;
            while (uniqueElement > k) {
                freq[s.charAt(L)-'a']--;
                if (freq[s.charAt(L)-'a'] == 0) uniqueElement--;
                L++;
            }
            update(L, R);
            R++;
        }
    }
    static void update(int L, int R) {
        int len = R - L + 1;
        if (len > max || (len == max && L < start)) {
            max = len; start = L; end = R;
        }
    }
}
