package String_algo.Window_algo;

import java.util.Scanner;

public class Balanced_BinaryString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            int n = scan.nextInt(), k = scan.nextInt(); scan.nextLine();
            String s = scan.nextLine();
            if (isBalanced(s, n, k)) System.out.println("YES");
            else System.out.println("NO");
        }
    }
    static boolean isBalanced(String s, int n, int k) {
        char[] arr = s.toCharArray();
        for (int i = 0; i < k; i++) {
            boolean one = false, zero = false, qs = false;
            for (int j = i; j < n; j += k) {
                if (arr[j] == '1') one = true;
                if (arr[j] == '0') zero = true;
                if (arr[j] == '?') qs = true;
            }
            if (one && zero) return false;
            else if (one) {
                for (int j = i; j < n; j += k) arr[j] = '1';
            } else if (zero) {
                for (int j = i; j < n; j += k) arr[j] = '0';
            }
        }
        int one = 0, zero = 0, qs = 0;
        for (int i = 0; i < k; i++) {
            one += arr[i] == '1'? 1: 0;
            zero += arr[i] == '0'? 1: 0;
            qs += arr[i] == '?'? 1: 0;
        }
        qs -= Math.abs(one - zero);
        return qs >= 0 && qs % 2 == 0;
    }
}
