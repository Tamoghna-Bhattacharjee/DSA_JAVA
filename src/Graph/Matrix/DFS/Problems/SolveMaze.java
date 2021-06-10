package Graph.Matrix.DFS.Problems;

import java.util.Scanner;

// https://codeforces.com/contest/1365/problem/D
public class SolveMaze {
    static char[][] maze;
    static int n, m;
    static int[] a = {-1, 1};
    static boolean[][] visit;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt(); scan.nextLine();
        while (T-- > 0) {
            n = scan.nextInt(); m = scan.nextInt(); scan.nextLine();
            maze = new char[n][m];
            for (int i = 0; i < n; i++) maze[i] = scan.nextLine().toCharArray();
            boolean GadjB = false;
            for (int i = 0; i < n && !GadjB; i++) {
                for (int j = 0; j < m && !GadjB; j++) {
                    if (maze[i][j] == 'B') {
                        blockB(i, j);
                        GadjB = isGadjB(i, j);
                    }
                }
            }
            if (GadjB) {
                System.out.println("No"); continue;
            }
            visit = new boolean[n][m];
            dfs(n-1, m-1);
            boolean goodEscape = true;
            for (int i = 0; i < n && goodEscape; i++) {
                for (int j = 0; j < m && goodEscape; j++) {
                    if (maze[i][j] == 'G' && !visit[i][j]) goodEscape = false;
                }
            }
            if (goodEscape) System.out.println("Yes");
            else System.out.println("No");
        }
    }

    static void dfs(int i, int j) {
        if (maze[i][j] == '#') return;
        visit[i][j] = true;
        for (int c: a) {
            if (i+c >= 0 && i+c < n && (maze[i+c][j] == '.' || maze[i+c][j] == 'G') && !visit[i+c][j]) {
                dfs(i+c, j);
            }
            if (j+c >= 0 && j+c < m && (maze[i][j+c] == '.' || maze[i][j+c] == 'G') && !visit[i][j+c]) {
                dfs(i, j+c);
            }
        }
    }
    static void blockB(int i, int j) {
        for (int c: a) {
            if (i+c >= 0 && i+c < n && maze[i+c][j] == '.') maze[i+c][j] = '#';
            if (j+c >= 0 && j+c < m && maze[i][j+c] == '.') maze[i][j+c] = '#';
        }
    }
    static boolean isGadjB(int i, int j) {
        for (int c: a) {
            if (i+c >= 0 && i+c < n && maze[i+c][j] == 'G') return true;
            if (j+c >= 0 && j+c < m && maze[i][j+c] == 'G') return true;
        }
        return false;
    }
}