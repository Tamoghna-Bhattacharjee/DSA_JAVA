package Working_with_Ranges.SQRT_Decomposition.MO_algo;

import java.util.*;
// https://www.codechef.com/problems/MDSWIN2
public class Winning_Ways2 {
    static int[] arr, freq, cof;
    static long[] ans, f1, f2, inv;
    static boolean[] toAdd;
    static int maxN = 100000, xor = 0, BLK = 300;
    static Comparator<Query> cmp;
    static long mod = 998244353;
    static List<Query> pq;
    static List<Integer> list;

    public static void main(String[] args) {
        factorials();
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            int n = scan.nextInt();
            arr = new int[n]; freq = new int[maxN+1]; cof = new int[maxN+1];
            toAdd = new boolean[maxN+1];
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                arr[i] = scan.nextInt();
                if (!map.containsKey(arr[i])) map.put(arr[i], map.size());
                arr[i] = map.get(arr[i]);
            }
            cmp = new Comparator<Query>() {
                @Override
                public int compare(Query q1, Query q2) {
                    int a = q1.l/BLK, b = q2.l/BLK;
                    if (a != b) return a-b;
                    return q1.r-q2.r;
                }
            };
            pq = new ArrayList<>();
            list = new ArrayList<>();
            int Q = scan.nextInt();
            ans = new long[Q];
            for (int i = 0; i < Q; i++) {
                int l = scan.nextInt()-1, r =scan.nextInt()-1;
                pq.add(new Query(l,r,i));
            }
            pq.sort(cmp);
            xor = 0;
            moAlgo();
            for (int i = 0; i < Q; i++) {
                System.out.println(ans[i]);
            }
        }
    }
    static void upd(int val, int op) {
        xor ^= freq[val];
        cof[freq[val]]--;
        freq[val] += op;
        cof[freq[val]]++;
        xor ^= freq[val];
        if (!toAdd[freq[val]]) {
            toAdd[freq[val]] = true;
            list.add(freq[val]);
        }
    }
    static void moAlgo() {
        int ML = 0, MR = -1;
        for (Query curr: pq) {
            int l = curr.l, r = curr.r, ind = curr.ind;
            //add
            while (ML > l) {ML--; upd(arr[ML], 1);}
            while (MR < r) {MR++; upd(arr[MR], 1);}
            //remove
            while (ML < l) {upd(arr[ML], -1); ML++;}
            while (MR > r) {upd(arr[MR], -1); MR--;}

            List<Integer> temp = new ArrayList<>();
            for (int i: list) {
                if (cof[i] == 0) {
                    toAdd[i] = false;continue;
                }
                temp.add(i);
                int x = xor ^ i;
                if (x < i) {
                    ans[ind] = (ans[ind] + cof[i]*f1[i]%mod*f2[x]%mod*f2[i-x])%mod;
                }
            }
            list = temp;
        }
    }
    static void factorials() {
        f1 = new long[maxN+1]; f2 = new long[maxN+1]; inv = new long[maxN+1];
        inv[1] = 1;
        for (int i = 2; i <= maxN; i++)
            inv[i] = (mod - (mod/i) * inv[(int) mod%i] % mod) % mod;
        f1[0] = f2[0] = 1;
        for (int i = 1; i <= maxN; i++) {
            f1[i] = ((f1[i-1]%mod) * (i%mod))%mod;
            f2[i] = ((f2[i-1]%mod) * (inv[i]%mod))%mod;
        }
    }
    static class Query {
        int l, r, ind;
        public Query(int l, int r, int ind) {
            this.l = l; this.r = r; this.ind = ind;
        }
    }
}

