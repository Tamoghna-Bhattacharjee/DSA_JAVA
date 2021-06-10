package Constructive_algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// https://codeforces.com/contest/1367/problem/E

public class Necklace_Assembly {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            int n = scan.nextInt(), k = scan.nextInt(); scan.nextLine();
            String s = scan.nextLine();
            int res = 0;
            int[] cnt = new int[26];
            for (char ch: s.toCharArray()) cnt[ch-'a']++;

            for (int len = 1; len <= n; len++) {
                ArrayList<Integer> cycle = new ArrayList<>();
                boolean[] visit = new boolean[len];

                for (int i = 0; i < len; i++) {
                    if (visit[i]) continue;
                    visit[i] = true;
                    int f = 1;
                    int j = (i+k) % len;
                    while (!visit[j]) {
                        visit[j] = true;
                        j = (j+k) % len;
                        f++;
                    }
                    cycle.add(f);
                }
                boolean canCycle = true;
                int[] freq = Arrays.copyOf(cnt, 26);
                Arrays.sort(freq);
                cycle.sort((a, b) -> b-a);

                for (int i: cycle) {
                    if (i > freq[25]) {
                        canCycle = false; break;
                    } else {
                        freq[25] -= i;
                        Arrays.sort(freq);
                    }
                }
                if (canCycle) res = len;
            }
            System.out.println(res);
        }
    }

}
