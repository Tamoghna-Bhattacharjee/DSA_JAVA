package Constructive_algo;

import java.util.ArrayList;
import java.util.Scanner;

// https://codeforces.com/contest/1382/problem/C2

public class PreixFlip {
    static String s1, s2;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            int n = scan.nextInt(); scan.nextLine();
            s1 = scan.nextLine(); s2 = scan.nextLine();
            solve(n, s1, s2);
        }
    }
    static void solve(int n, String s1, String s2) {
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if (s1.charAt(i) != s1.charAt(i-1)) res.add(i);
        }
        char ch = s1.charAt(n-1);
        for (int i = n-1; i >= 0; i--) {
            if (s2.charAt(i) != ch) {
                ch = s2.charAt(i);
                res.add(i+1);
            }
        }
        StringBuilder builder = new StringBuilder();
        builder.append(res.size()).append(" ");
        for (int i: res) builder.append(i).append(" ");
        System.out.println(builder);
    }
}
