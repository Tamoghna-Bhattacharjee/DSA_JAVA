package String_algo;

// longest palindromic substring

import java.util.Scanner;

public class ManacherAlgo {
    static int[] palHalfLen; // it gives the longest palindrome across any centre
    static int start, end, maxLen;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt(); scan.nextLine();
        while (T-- > 0) {
            String s = scan.nextLine();
            System.out.println(solve(s));
        }
    }
    static String solve(String s) {
        int n = s.length();
        StringBuilder builder = new StringBuilder("$#");
        for (int i = 0; i < n; i++) builder.append(s.charAt(i)).append("#");
        builder.append("@");
        String newStr = builder.toString();
        int len = newStr.length();
        manacherAlgo(newStr, len);

        String temp = newStr.substring(start, end+1);
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < temp.length(); i++) {
            if (temp.charAt(i) >= 'a' && temp.charAt(i) <= 'z')
                res.append(temp.charAt(i));
        }
        return res.toString();
    }
    static void manacherAlgo(String s, int n) {
        palHalfLen = new int[n];
        start = 1; end = 1; maxLen = 1;
        int C = 0, R = 0;
        for (int i = 1; i < n-1; i++) {
            int mirr = C - (i-C);
            if (i < R) palHalfLen[i] = Math.min(R-i, palHalfLen[mirr]);
            while (s.charAt(i + (1 + palHalfLen[i])) == s.charAt(i - (1 + palHalfLen[i])))
                palHalfLen[i]++;
            if (i + palHalfLen[i] > R) {
                C = i;
                R = i + palHalfLen[i];
            }
            update(i);
        }
    }
    static void update(int i) {
        if (palHalfLen[i] > maxLen || (palHalfLen[i] == maxLen && i < start)) {
            maxLen = palHalfLen[i];
            start = i - palHalfLen[i]; end = i + palHalfLen[i];
        }
    }
}
