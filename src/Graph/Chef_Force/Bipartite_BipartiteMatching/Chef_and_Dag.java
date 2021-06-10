package Graph.Chef_Force.Bipartite_BipartiteMatching;

import java.util.*;
// https://www.codechef.com/MARCH20B/problems/CHEFDAG
public class Chef_and_Dag {
    static Map<Integer, Set<Integer>> map;
    static int[] mt;
    static int[] ans;
    static Set<Integer> visit;
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            int n = scan.nextInt(), k = scan.nextInt();
            map = new HashMap<>();
            for (int i = 1; i <= n; i++) {
                Set<Integer> s = new HashSet<>();
                for (int j = 1; j <= n; j++) {
                    if (j != i) s.add(j);
                }
                map.put(i, s);
            }
            int[] arr = new int[n];
            while (k-- > 0) {
                for (int i = 0; i < n; i++) {
                    arr[i] = scan.nextInt();
                    for (int j = 0; j < i; j++) {
                        map.get(arr[i]).remove(arr[j]);
                    }
                }
            }
            //System.out.println(map);
            mt = new int[n+1];
            ans = new int[n+1];
            for (int i = 1; i <= n; i++) {
                visit = new HashSet<>();
                bpm(i);
            }
            int cnt = 0;
            for (int i = 1; i <= n; i++) {
                if (ans[i] == 0) cnt++;
            }
            System.out.println(cnt);
            for (int i = 1; i <= n; i++) {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
    public static boolean bpm(int node) {
        visit.add(node);
        for (int child: map.get(node)) {

            if (mt[child] <= 0 || (!visit.contains(mt[child]) && bpm(mt[child])))
            {
                mt[child] = node;
                ans[node] = child;
                return true;

            }
        }
        return false;
    }
}
