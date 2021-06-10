package Constructive_algo;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
// https://codeforces.com/contest/1373/problem/C
public class Pluses_and_MInuses {
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
        Map<Integer, Integer> map = new HashMap<>();
        int min = 0, curr = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '+') curr++;
            else curr--;
            if (!map.containsKey(curr)) map.put(curr, i);
            min = Math.min(min, curr);
        }
        min = -min;
        long sum = n;
        for (int i = 0; i < min; i++) {
            int x = -1-i;
            sum += map.getOrDefault(x, -1)+1;
        }
        System.out.println(sum);
    }
}
