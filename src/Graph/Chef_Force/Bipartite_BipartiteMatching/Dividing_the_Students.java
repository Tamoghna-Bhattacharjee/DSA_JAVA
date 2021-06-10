package Graph.Chef_Force.Bipartite_BipartiteMatching;

import java.util.*;
// https://www.codechef.com/problems/DIVIDE
public class Dividing_the_Students {
    static int[] arr;
    static int[][] sim;
    static long mod = (long) Math.pow(10, 9) + 7;
    static Map<Integer, Set<Integer>> map;
    static Map<Integer, Integer> color;
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            int n = scan.nextInt();
            arr = new int[n];
            sim = new int[n][n];
            for (int i = 0; i < n; i++) arr[i] = scan.nextInt();
            similarity(n);
            solve(n);
        }
    }
    public static void solve(int n) {
        long left = 0, right = mod - 1;
        long mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if (check((int)mid, n)) right = mid;
            else left = mid+1;
        }
        System.out.println(left);
    }

    public static boolean check(int x, int n) {
        map = new HashMap<>();
        for (int i = 0; i < n; i++) map.put(i, new HashSet<>());
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (sim[i][j] > x) {
                    map.get(i).add(j); map.get(j).add(i);
                }
            }
        }
        color = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!color.containsKey(i)) {
                if (!bp(i, 0)) return false;
            }
        }
        return true;
    }

    public static boolean bp(int node, int c) {
        color.put(node, c);
        for (int child: map.get(node)) {
            if (!color.containsKey(child)) {
                if (!bp(child, 1-c)) return false;
            }else{
                if (color.get(child) == c) return false;
            }
        }
        return true;
    }

    public static void similarity(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                sim[i][j] = sim[j][i] = (int) Math.min(pow(arr[i], arr[j]) % mod, pow(arr[j], arr[i]) % mod);
            }
        }
    }

    public static int pow(long a, int b) {
        // a^b
        if (b == 0 || a == 1) return 1;
        if (a == 0 || b == 1) return (int) a;
        long res = 1;
        while (b > 0) {
            if (b % 2 == 1) res = ((res % mod) * (a % mod)) % mod;
            a = ((a % mod) * (a % mod)) % mod;
            b /= 2;
        }
        return (int) res;
    }
}
