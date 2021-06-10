package Graph.Matrix.DFS;

import java.util.Scanner;

public class Counting_ConnectedComponent {
    static int N, M;
    static char[][] G;
    static boolean[][] visit;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt(); M = scan.nextInt(); scan.nextLine();
        G = new char[N][M];
        visit = new boolean[N][M];
        for (int i = 0; i < N; i++) G[i] = scan.nextLine().toCharArray();
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (G[i][j] == '.' && !visit[i][j]) {
                    cnt++; dfs(i, j);
                }
            }
        }
        System.out.println(cnt);
    }
    static void dfs(int x, int y) {
        visit[x][y] = true;
        for (int i = 0; i < 4; i++)
            if (isValid(x+dx[i], y+dy[i]))
                dfs(x+dx[i], y+dy[i]);
    }
    static boolean isValid(int i, int j) {
        if (i < 0 || j < 0 || i >= N || j >= M) return false;
        if (visit[i][j] || G[i][j] == '#') return false;
        return true;
    }
}
