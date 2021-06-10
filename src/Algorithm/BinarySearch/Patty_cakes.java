package Algorithm.BinarySearch;

import java.util.*;
// https://codeforces.com/contest/1393/problem/C

public class Patty_cakes {
    static int[] a;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            int n = scan.nextInt();
            a = new int[n];
            for (int i = 0; i < n; i++) a[i] = scan.nextInt();

            int L = 0, R = n, ans = 0;
            while (L <= R) {
                int mid = (L + R) / 2;
                if (check(mid, n)) {
                    ans = Math.max(ans, mid-1); L = mid+1;
                } else R = mid-1;
            }
            System.out.println(ans);
        }
    }
    static boolean check(int d, int n) {
        Map<Integer, Integer> F = new HashMap<>();
        for (int i: a) F.put(i, F.getOrDefault(i, 0) + 1);
        PriorityQueue<pair> pq = new PriorityQueue<>((a, b) -> b.cnt-a.cnt);
        for (Map.Entry<Integer, Integer> i: F.entrySet())
            pq.add(new pair(i.getKey(), i.getValue()));
        int[] arr = new int[n];
        int i = 0;
        while (i < n) {
            if (i >= d && arr[i-d] > 0 && F.get(arr[i-d]) > 0) {
                pq.add(new pair(arr[i-d], F.get(arr[i-d])));
            }
            if (pq.isEmpty()) break;
            pair curr = pq.poll();
            arr[i] = curr.num; F.put(curr.num, curr.cnt-1);
            i++;
        }
        //System.out.println(Arrays.toString(arr) + " " + d);
        return i == n;
    }
    static class pair {
        int num, cnt;
        public pair(int n, int c) {
            num = n; cnt = c;
        }
    }
}
