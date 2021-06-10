package String_algo.KMP;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KMP_PatternMatching {
    static int[] LPS;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String T = scan.nextLine(), p = scan.nextLine();
        mkLPS(p);
        System.out.println(getMatchedIndex(T, p));
    }
    static List<Integer> getMatchedIndex(String T, String P) {
        int i = 0, j = 0;
        List<Integer> mtIndex = new ArrayList<>();
        while (i < T.length()) {
            if (T.charAt(i) == P.charAt(j)) {
                i++; j++;
            }
            if (j == P.length()) {
                mtIndex.add(i-j);
                j = LPS[j-1];
            }
            else if (i < T.length() && T.charAt(i) != P.charAt(j)) {
                if (j == 0) i++;
                else j = LPS[j-1];
            }
        }
        return mtIndex;
    }
    static void mkLPS(String p) {
        int n = p.length();
        LPS = new int[n];
        int i = 1, j = 0;
        while (i < n) {
            if (p.charAt(i) == p.charAt(j)) {
                LPS[i] = j+1;
                j++; i++;
            }else {
                if (j == 0) {
                    LPS[i] = 0; i++;
                } else j = LPS[j-1];
            }
        }
    }
}
