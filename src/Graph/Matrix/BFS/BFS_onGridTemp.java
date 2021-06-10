package Graph.Matrix.BFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS_onGridTemp {
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    static boolean[][] visit;
    static int[][] dist;
    static int R, C;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        R = scan.nextInt(); C = scan.nextInt();
        visit = new boolean[R][C];
        dist = new int[R][C];
        bfs(scan.nextInt()-1, scan.nextInt()-1);
        for (int[] i: dist) System.out.println(Arrays.toString(i));
    }
    static void bfs(int srcX, int srcY) {
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(srcX, srcY));
        visit[srcX][srcY] = true;
        dist[srcX][srcY] = 0;
        while (!q.isEmpty()) {
            pair curr = q.poll();
            int currX = curr.x, currY = curr.y;
            for (int i = 0; i < 4; i++) {
                if (isValid(currX+dx[i], currY+dy[i])) {
                    int newX = currX+dx[i], newY = currY+dy[i];
                    dist[newX][newY] = dist[currX][currY]+1;
                    visit[newX][newY] = true;
                    q.add(new pair(newX, newY));
                }
            }
        }
    }
    static boolean isValid(int i, int j) {
        if (i < 0 || j < 0 || i >= R || j >= C) return false;
        if (visit[i][j]) return false;
        return true;
    }
    static class pair {
        int x, y;
        public pair(int x, int y) {
            this.x = x; this.y = y;
        }
    }
}
