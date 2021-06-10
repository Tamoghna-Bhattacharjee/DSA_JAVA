package String_algo.Constructive_Problems;

import java.util.Scanner;
import java.util.Stack;

// https://codeforces.com/contest/1354/problem/B

public class TernaryString {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt(); scan.nextLine();
        while (T-- > 0) {
            String s = scan.nextLine();
            Stack<Pair> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                if (stack.isEmpty() || stack.peek().ch != s.charAt(i))
                    stack.push(new Pair(s.charAt(i), 1));
                else stack.peek().blk++;
            }
            int ans = Integer.MAX_VALUE;
            for (int i = 1; i < stack.size()-1; i++) {
                if (stack.get(i-1).ch != stack.get(i+1).ch)
                    ans = Math.min(ans, stack.get(i).blk + 2);
            }
            System.out.println((ans > s.length()? 0: ans));
        }
    }
    static class Pair {
        char ch;
        int blk; // block size;
        Pair(char ch, int blk) {
            this.ch = ch; this.blk = blk;
        }
    }
}
