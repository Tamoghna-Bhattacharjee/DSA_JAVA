package Graph.Chef_Force;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
// https://www.codechef.com/problems/RBTREE
public class Chef_and_RedBlackTree {
    static int root_c = 0; // black
    static Map<Integer, Integer> parx, pary;
    static int b = 0, r = 0;
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner scan = new Scanner(System.in);
        int Q = scan.nextInt(); scan.nextLine();
        while (Q-- > 0) {
            String q = scan.nextLine();
            if (q.length() == 2) {
                root_c = 1 - root_c;
            }
            else {
                String[] str = q.split(" ");
                int x = Integer.parseInt(str[1]), y = Integer.parseInt(str[2]);
                int colx = -1, coly = -1;
                parx = new HashMap<>(); pary = new HashMap<>();
                f(x, 'x'); f(y, 'y');
                if (parx.size() % 2 == 0) colx = root_c;
                else colx = 1 - root_c;
                int p = 1;
                for (int i: parx.keySet()) {
                    if (pary.containsKey(i)) p = Math.max(p, i);
                }
                dist(x, y, p, colx);
                if (str[0].equals("Qb")) System.out.println(b);
                else System.out.println(r);
            }
        }
    }
    public static void dist (int x, int y, int p, int colx) {
        int d = 0;
        b = 0; r = 0;
        while (x != p) {
            d++; x /= 2;
        }
        while (y != p) {
            d++; y/= 2;
        }
        if (d % 2 == 1) {
            b = d/2 + 1; r = d/2 + 1;
        }else {
            b = d/2; r = d/2;
            if (colx == 0) b+=1;
            else r+=1;
        }
    }
    public static void f(int n, char ch) {
        Map<Integer, Integer> map = (ch == 'x')? parx: pary;
        while (n > 1) {
            map.put(n, n/2);
            n/=2;
        }
    }
}
