package Constructive_algo;

import java.util.ArrayList;
import java.util.Scanner;

// https://codeforces.com/contest/1384/problem/B2

public class Koa_Beach {
    static int[] d;
    static ArrayList<Integer> safe;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            int n = scan.nextInt(), k = scan.nextInt(), l = scan.nextInt();
            d = new int[n+1];
            safe = new ArrayList<>();
            safe.add(0);
            for (int i = 1; i <= n; i++) {
                d[i] = scan.nextInt();
                if (d[i] + k <= l) safe.add(i);
            }
            safe.add(n+1);
            boolean ok = true;
            for (int i = 1; i < safe.size() && ok; i++) {
                int tide = k;
                boolean down = true;
                for (int j = safe.get(i-1)+1; j < safe.get(i) && ok; j++) {
                    tide += down? -1: 1;
                    if (down) {
                        if (d[j] + tide > l) tide -= d[j] + tide - l;
                        if (tide < 0) ok = false;
                    } else ok = d[j]+tide <= l;
                    if (tide == 0) down = false;
                }
            }
            if (ok) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
