package Constructive_algo;

import java.util.Scanner;

// https://codeforces.com/contest/1363/problem/B
// fuck you for not getting this

public class Subsequence_Hate {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt(); scan.nextLine();
        while (T-- > 0) {
            String s = scan.nextLine();
            solve(s);
        }
    }
    static void solve(String s) {
        int n = s.length();
        int[] suf = new int[2], pref = new int[2];
        for (int i = 0; i < n; i++) suf[s.charAt(i)-48]++;
        int ans = Math.min(suf[0], suf[1]); // all char to be 1 or 0
        for (int i = 0; i < n; i++) {
            pref[s.charAt(i)-48]++;
            suf[s.charAt(i)-48]--;
            ans = Math.min(ans, Math.min(suf[1] + pref[0], suf[0] + pref[1]));
        }
        System.out.println(ans);
    }
}
