package String_algo.Constructive_Problems;

import java.util.PriorityQueue;
import java.util.Scanner;
// https://www.codechef.com/COOK117B/problems/MINOPS

public class Simple_Operations {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();scan.nextLine();
        while (T-- > 0) {
            String S = scan.nextLine(), R = scan.nextLine();
            PriorityQueue<Long> gap = new PriorityQueue<>((a,b)-> (int) (b-a));
            int n = S.length();
            boolean diff = false;
            long k = 1, l = 0, gapLength = 0;
            for (int i = 0; i < n; i++) {
                if (S.charAt(i) != R.charAt(i)) {
                    if (gapLength > 0 && diff) {
                        gap.add(gapLength);
                        l += gapLength;
                    }
                    diff = true;
                    gapLength = 0;
                    l++;
                }else gapLength++;
            }
            long ans = k*l;
            while (!gap.isEmpty()) {
                l -= gap.poll();
                k++;
                ans = Math.min(ans, k*l);
            }
            System.out.println(ans);
        }
    }
}
