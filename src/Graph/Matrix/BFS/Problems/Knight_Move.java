package Graph.Matrix.BFS.Problems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// https://www.codechef.com/problems/PRGCUP01

public class Knight_Move {
    static int[] di = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[] dj = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[][] M;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt(); scan.nextLine();
        while (T-- > 0) {
            String[] s = scan.nextLine().split(" ");
            M = new int[9][9];
            for (int[] i: M) Arrays.fill(i, Integer.MAX_VALUE);
            int sR = 9 - (s[0].charAt(1) - 48);
            int sC = s[0].charAt(0) - 96;
            bfs(sR, sC);
            int eR = 9 - (s[1].charAt(1) - 48);
            int eC = s[1].charAt(0) - 96;
            System.out.println(M[eR][eC]);
        }
    }
    static void bfs(int srcI, int srcJ) {
        M[srcI][srcJ] = 0;
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(srcI, srcJ));
        while (!q.isEmpty()) {
            pair curr = q.poll();
            int currI = curr.i, currJ = curr.j;
            for (int i = 0; i < 8; i++) {
                int newI = currI + di[i], newJ = currJ + dj[i];
                if (isValid(newI, newJ)) {
                    if (M[currI][currJ] + 1 < M[newI][newJ]) {
                        M[newI][newJ] = 1 + M[currI][currJ];
                        q.add(new pair(newI, newJ));
                    }
                }
            }
        }
    }
    static boolean isValid(int i, int j) {
        return i >= 1 && j >= 1 && i <= 8 && j <= 8;
    }
    static class pair {
        int i, j;
        pair(int i, int j) {
            this.i = i; this.j = j;
        }
    }
}
