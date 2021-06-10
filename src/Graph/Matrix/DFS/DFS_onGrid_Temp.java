package Graph.Matrix.DFS;

import java.util.Scanner;

public class DFS_onGrid_Temp {
    static boolean[][] visit;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    static int R, C;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        R = scan.nextInt(); C = scan.nextInt();
        visit = new boolean[R][C];
        dfs(0, 0);
    }
    static void dfs(int x, int y) {
        visit[x][y] = true;
        System.out.println(x + " " + y);
        for (int i = 0; i < 4; i++) {
            if (isValid(x+dx[i], y+dy[i])) dfs(x+dx[i], y+dy[i]);
        }
    }
    static boolean isValid(int x, int y) {
        if (x < 0 || y < 0 || x >= C || y >= R) return false;
        if (visit[x][y]) return false;
        return true;
    }
}
