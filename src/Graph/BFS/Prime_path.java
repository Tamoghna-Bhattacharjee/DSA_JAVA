package Graph.BFS;

import java.util.*;

public class Prime_path {
    // source: https://www.spoj.com/problems/PPATH/
    static Map<Integer, Set<Integer>> map = new HashMap<>();
    static Map<Integer, Integer> dist;
    static ArrayList<Integer> primes = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        selectPrime();
        makeGraph();
        int T = scan.nextInt();
        for (int t = 0; t < T; t++) {
            dist = new HashMap<>();
            int low = scan.nextInt(), high = scan.nextInt();
            bfs(low);
            System.out.println(dist.containsKey(high)? dist.get(high): "Impossible");
        }
    }

    public static void bfs(int node) {
        dist.put(node, 0);
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int child: map.get(curr)) {
                // since unidirectional graph no requirement of validation
                if (!dist.containsKey(child)) {
                    q.add(child);
                    dist.put(child, dist.get(curr) + 1);
                }
            }
        }
    }

    private static void makeGraph() {
        for (int i = 0; i < primes.size(); i++) {
            for (int j = i+1; j < primes.size(); j++) {
                int x = primes.get(i), y = primes.get(j);
                if (isValid(x, y)) {
                    map.get(x).add(y); map.get(y).add(x);
                }
            }
        }
    }

    private static boolean isValid(int x, int y) {
        int cnt = 0;
        while (x > 0) {
            if (x % 10 != y % 10) cnt++;
            x /= 10; y /= 10;
        }
        return cnt == 1;
    }

    public static void selectPrime() {
        for (int i = 1000; i <= 9999; i++) {
            if (isPrime(i)) {
                primes.add(i);
                map.put(i, new HashSet<>());
            }
        }
    }

    private static boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
