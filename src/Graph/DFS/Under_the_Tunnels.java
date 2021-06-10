package Graph.DFS;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// Under the tunnels of Alamut, you have discovered a path ― a sequence of N tiles
// (numbered 1 through N) ahead of you. You are currently on tile 1. There is a signboard beside
// you, which says thus:
// Stepping on tile i (for each valid i) activates a switch described by a binary string Si with
// length N. When you fell through the tunnels onto tile 1, switch S1 got activated.
// For each valid i, when the switch Si gets activated, then for each j (1≤j≤N), if the j-th
// character of Si is '0', tile j becomes unsafe to step on; otherwise (if the j-th character
// is '1'), tile j becomes safe to step on.
// Step on an unsafe tile and you shall testify the fate of all men ― death!
// You shall find that which you seek on reaching tile N. This tile must also be safe when
// you step on it.Being a trained warrior, you are able to make jumps with length up to K tiles,
// in both directions. In other words, if you are currently at a tile i, you may jump to a tile
// j if j is a valid tile and |i−j|≤K.You want to reach tile N as quickly as possible ― you
// want to minimise the number of jumps you need to make. Find this minimum number of jumps.

public class Under_the_Tunnels {
    public static void main(String[] args) {
        int n = 5, k = 2;
        String[] s = {"11001" ,"01010" ,"10101" ,"00110" ,"10101"};
        System.out.println(findMinRoute(s, n, k));
        n = 3; k = 1;
        String[] s2 = {"110", "010", "011"};
        System.out.println(findMinRoute(s2, n, k));
    }

    private static int findMinRoute(String[] s, int n, int k) {
        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        boolean[] visit = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        dis[0] = 0;
        visit[0] = true;

        while (!q.isEmpty()){
            int a = q.poll();
            for (int i = 0; i < n; i++) {
                if (Math.abs(i - a) <= k && i != a && !visit[i] && s[a].charAt(i) == '1') {
                    visit[i] = true;
                    dis[i] = dis[a] + 1;
                    q.add(i);
                }
            }
        }
        if (dis[n-1] == Integer.MAX_VALUE) return -1;
        else return dis[n-1];
    }
}
