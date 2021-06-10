package Graph.Matrix.DFS.Problems;

import java.util.Arrays;
import java.util.Scanner;
// https://www.hackerearth.com/practice/algorithms/graphs/depth-first-search/practice-problems/algorithm/jungle-run/submissions/

public class JungleRun {
    static String[][] matrix;
    static int[][] dist;
    static int[] a = {-1, 1};
    static int n;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt(); scan.nextLine();
        matrix = new String[n][n];
        dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            matrix[i] = scan.nextLine().split(" ");
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        int si = -1, sj = -1, ei = -1, ej = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j].equals("S")) {
                    si = i; sj = j;
                }
                if (matrix[i][j].equals("E")) {
                    ei = i; ej = j;
                }
            }
        }
        dist[si][sj] = 0;
        dfs(si, sj);
        System.out.println(dist[ei][ej]);
    }
    static void dfs(int i, int j) {
        if (matrix[i][j].equals("E")) return;
        for (int c: a) {
            if (i+c >= 0 && i+c < n && !matrix[i+c][j].equals("T")) {
                if (dist[i][j] + 1 < dist[i+c][j]) {
                    dist[i+c][j] = dist[i][j]+1;
                    dfs(i+c, j);
                }
            }
            if (j+c >= 0 && j+c < n && !matrix[i][j+c].equals("T")) {
                if (dist[i][j]+1 < dist[i][j+c]) {
                    dist[i][j+c] = dist[i][j]+1;
                    dfs(i, j+c);
                }
            }
        }

    }
}
