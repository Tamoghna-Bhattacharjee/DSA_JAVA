package Working_with_Ranges.SQRT_Decomposition.MO_algo;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
//https://www.spoj.com/problems/FREQ2/
public class Most_Frequent_Value {
    static int[] arr, freq, cof, ans; // cof -> counter of frequency
    static Comparator<Quary> cmp;
    static int BLK, res;
    static PriorityQueue<Quary> queries;

    public static void main (String[] args) throws java.lang.Exception  {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(), Q = scan.nextInt();
        init(n, Q);
        for (int i = 0; i < n; i++) arr[i] = scan.nextInt();
        for (int i = 0; i < Q; i++) {
            int l = scan.nextInt(), r = scan.nextInt();
            queries.add(new Quary(l, r, i));
        }
        moAlgo(Q);
        for (int i = 0; i < Q; i++) System.out.println(ans[i]);
    }
    static void moAlgo(int Q) {
        int ML = 0, MR = -1;
        while (!queries.isEmpty()) {
            Quary curr = queries.poll();
            int l = curr.l, r = curr.r, ind = curr.i;
            // add
            while (ML > l) {
                ML--; add(ML);
            }
            while (MR < r) {
                MR++; add(MR);
            }
            //remove
            while (ML < l) {
                remove(ML); ML++;
            }
            while (MR > r) {
                remove(MR); MR--;
            }
            ans[ind] = res;
        }
    }

    static void add(int i) {
        int val = arr[i];
        cof[freq[val]]--;
        freq[val]++;
        cof[freq[val]]++;
        res = Math.max(res, freq[val]);
    }
    static void remove(int i) {
        int val = arr[i];
        cof[freq[val]]--;
        freq[val]--;
        cof[freq[val]]++;
        while(cof[res] == 0) res--;
    }

    static void init(int n, int Q) {
        BLK = (int) Math.floor(Math.sqrt(n));
        cmp = new Comparator<>(){
            @Override
            public int compare(Quary q1, Quary q2) {
                int a = q1.l/BLK, b = q2.l/BLK;
                if (a != b) return a-b;
                return q1.r - q2.r;
            }
        };
        arr = new int[n];
        freq = new int[100001];
        cof = new int[100001];
        queries = new PriorityQueue<>(cmp);
        ans = new int[Q];
        res = 0;
    }
    static class Quary{
        int l, r, i;
        public Quary(int l, int r, int i) {
            this.l = l;
            this.r = r;
            this.i = i;
        }
    }
}
