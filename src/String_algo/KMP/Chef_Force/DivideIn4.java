package String_algo.KMP.Chef_Force;

import java.util.Scanner;
// https://www.codechef.com/problems/CHEFSHIP
public class DivideIn4 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt(); scan.nextLine();
        while (T-- > 0) {
            StringBuilder builder = new StringBuilder(scan.nextLine());
            int n = builder.length();
            int[] LPS1 = new int[n], LPS2 = new int[n];
            computeLPS(builder.toString(), LPS1);
            computeLPS(builder.reverse().toString(), LPS2);
            long cnt = 0;
            for (int i = 1; i < n-2; i+=2) {
                int len1 = i+1, len2 = n-len1;
                int half1 = len1/2, half2 = len2/2;
                int p1 = len1-LPS1[len1-1], p2 = len2 - LPS2[len2-1];

                if (half1%p1 == 0 && half2%p2 == 0) cnt++;
            }
            System.out.println(cnt);
        }
    }
    static void computeLPS(String s, int[] LPS) {
        int i = 1, j = 0;
        while (i < s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                LPS[i] = j+1;
                j++; i++;
            } else {
                if (j == 0) {
                    LPS[i] = 0; i++;
                } else j = LPS[j-1];
            }
        }
    }
}
