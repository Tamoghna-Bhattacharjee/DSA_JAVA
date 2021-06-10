package String_algo.Constructive_Problems;

// represent 1/3 -> 0.(3)
// represent 1/7 -> 0.(142857)
// 1/6 -> 0.1(6)

import java.util.*;

public class Optimise_Irrational {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            int a = scan.nextInt(), b = scan.nextInt();
            System.out.println(f(a, b));
        }
    }
    static String f(int a, int b) {
        if (b == 0) return "INF";
        if (a == 0 || a % b == 0) return (a/b) + "";
        String str = "";
        if ((a < 0 && b > 0) || (a > 0 && b < 0)) str += "-";
        if (a < 0) a = -a;
        if (b < 0) b = -b;

        if (a >= b) str += a/b + ".";
        else str += "0.";
        a = a % b;
        List<String> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int brackInd = -1;
        while (a > 0) {
            a *= 10;
            if (map.containsKey(a)) {
                brackInd = map.get(a); break;
            }
            map.put(a, res.size());
            res.add(a/b + "");
            a = a % b;
        }
        for (int i = 0; i < res.size(); i++) {
            if (i == brackInd) str += "(";
            str += res.get(i);
        }
        if (brackInd != -1) str += ")";
        return str;
    }
}
