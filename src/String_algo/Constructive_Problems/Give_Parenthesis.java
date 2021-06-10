package String_algo.Constructive_Problems;

import java.io.IOException;
import java.util.Scanner;

// Given a string of digits S, insert a minimum number of opening and closing parentheses
// into it such that the resulting string is balanced and each digit d is inside exactly d
// pairs of matching parentheses.
//Let the nesting of two parentheses within a string be the substring that occurs strictly
// between them. An opening parenthesis and a closing parenthesis that is further to its
// right are said to match if their nesting is empty, or if every parenthesis in their
// nesting matches with another parenthesis in their nesting. The nesting depth of a position
// p is the number of pairs of matching parentheses m such that p is included in the nesting
// of m.
//For example, in the following strings, all digits match their nesting depth: 0((2)1),
// (((3))1(2)), ((((4)))), ((2))((2))(1). The first three strings have minimum length among
// those that have the same digits in the same order, but the last one does not since
// ((22)1) also has the digits 221 and is shorter.
//Given a string of digits S, find another string S', comprised of parentheses and digits,
// such that:
//all parentheses in S' match some other parenthesis,
//removing any and all parentheses from S' results in S,
//each digit in S' is equal to its nesting depth, and
//S' is of minimum length.
//Input
//The first line of the input gives the number of test cases, T. T lines follow. Each
// line represents a test case and contains only the string S.


public class Give_Parenthesis {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt(); scan.nextLine();
        for (int t = 1; t <= T; t++) {
            String s = scan.nextLine();
            int n = s.length();
            System.out.println("Case #" + t + ": " + solve(s, n));
        }
    }
    static String solve(String s, int n) {
        String ans = "";
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int num = s.charAt(i) - 48;
            if (num == cnt) ans += num;
            else if (num > cnt) {
                for (int j = 0; j < num - cnt; j++) ans += "(";
                ans += num; cnt = num;
            }else {
                for (int j = 0; j < cnt - num; j++) ans += ")";
                ans += num; cnt = num;
            }
        }
        while (cnt-- > 0) ans += ")";
        return ans;
    }
}
