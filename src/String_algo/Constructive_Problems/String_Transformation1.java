package String_algo.Constructive_Problems;

import java.util.Scanner;

// https://codeforces.com/contest/1384/problem/C

public class String_Transformation1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            int n = scan.nextInt(); scan.nextLine();
            solve(scan.nextLine().toCharArray(), scan.nextLine().toCharArray(), n);
        }
    }
    static void solve (char[] a, char[] b, int n) {
        boolean ok = true;
        for (int i = 0; i < n && ok; i++) ok = a[i] <= b[i];
        if (!ok) {
            System.out.println(-1); return;
        }
        int cnt = 0;
        for (char ch = 'a'; ch <= 't'; ch++) {
            int min = 255;
            for (int i = 0; i < n; i++) {
                if (a[i] == ch && a[i] != b[i]) min = Math.min(min, b[i]);
            }
            if (min != 255) {
                for (int i = 0; i < n; i++) {
                    if (a[i] == ch && a[i] != b[i]) a[i] = (char) min;
                }
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
