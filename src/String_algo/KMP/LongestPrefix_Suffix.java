package String_algo.KMP;

import java.util.Arrays;
import java.util.Scanner;

public class LongestPrefix_Suffix {
    static int[] LPS;
    static int max, start, end;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String s = scan.nextLine();
        max = 0; start = -1; end = -1;
        mkLPS(s);
        System.out.println(Arrays.toString(LPS));
        System.out.println(s.substring(start, end+1));
    }
    static void mkLPS(String s) {
        int n = s.length();
        LPS = new int[n];
        int i = 1, j = 0;
        while (i < n) {
            if (s.charAt(i) == s.charAt(j)) {
                LPS[i] = j+1; update(LPS[i], i);
                j++; i++;
            } else {
                if (j == 0) {
                    LPS[i] = 0; i++;
                } else j = LPS[j-1];
            }
        }
    }
    static void update(int len, int en) {
        int st = en-len+1;
        if (len > max) {
            max = len; start = st; end = en;
        }
    }

}
