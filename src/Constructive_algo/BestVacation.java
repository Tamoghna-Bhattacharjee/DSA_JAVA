package Constructive_algo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
// https://codeforces.com/contest/1358/problem/D
public class BestVacation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        long x = scan.nextLong();
        long[] arr = new long[2*n+1];
        for (int i = 1; i <= 2*n; i++) {
            if (i <= n) arr[i] = scan.nextInt();
            else arr[i] = arr[i-n];
        }
        Queue<Pair> q = new LinkedList<>();
        long sum = 0, ans = 0;
        for (int i = 1; i <= 2*n; i++) {
            q.add(new Pair(1, arr[i]));
            sum += (arr[i] * (arr[i] + 1)) / 2;
            x -= arr[i];
            while (x < 0) {
                Pair p = q.peek();
                long l = p.l, r = p.r;
                long diff = r-l+1;
                if (diff <= -x) {
                    x += diff;
                    sum -= (diff * (l + r)) / 2;
                    q.poll();
                } else {
                    diff = -x;
                    x = 0;
                    sum -= (diff * (l + (l + diff-1))) / 2;
                    p.l = l+diff;
                }
            }
            //System.out.println(sum + " " + arr[i] + " " + q + ": " + i);
            ans = Math.max(ans, sum);
        }
        System.out.println(ans);
    }
    static class Pair {
        long l, r;
        Pair(long l, long r) {
            this.l = l; this.r = r;
        }

        @Override
        public String toString() {
            return "(" + l + ", " + r + ")";
        }
    }
}

