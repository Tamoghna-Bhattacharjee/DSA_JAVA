package Graph.Chef_Force;

import java.util.*;
// https://www.codechef.com/problems/ANTHILL
public class Ant_Hill {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int n = scan.nextInt(), m = scan.nextInt(), a = scan.nextInt();
        int r = scan.nextInt();
        boolean[][] adj = new boolean[n+1][n+1];
        for (int i = 0; i < m; i++) {
            int u = scan.nextInt(), v = scan.nextInt();
            adj[u][v] = true; adj[v][u] = true;
        }
        ArrayList<int[]> arr = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            for (int j = i+1; j <= n; j++) {
                for (int k = j+1; k <= n; k++) {
                    if (adj[i][j] && adj[j][k] && adj[i][k]) {
                        int[] temp = {1,2,i,j,j,k};
                        arr.add(temp);
                        adj[i][j] = false; adj[j][i] = false;
                        adj[j][k] = false; adj[k][j] = false;
                        adj[i][k] = false; adj[k][i] = false;
                    }
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = i+1; j <= n; j++) {
                if (adj[i][j]) {
                    int[] temp = {1,1,i,j};
                    arr.add(temp);
                    adj[i][j] = false; adj[j][i] = false;
                }
            }
        }
        System.out.println(arr.size());
        for (int[] i: arr) {
            for (int j: i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
