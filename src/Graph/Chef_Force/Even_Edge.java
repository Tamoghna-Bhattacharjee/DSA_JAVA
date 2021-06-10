package Graph.Chef_Force;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
// https://www.codechef.com/problems/EVEDG
public class Even_Edge {
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            int n = scan.nextInt(), m = scan.nextInt();
            ArrayList<Integer>[] arr = new ArrayList[n+1];
            for (int i = 1; i <= n; i++) arr[i] = new ArrayList<Integer>();
            int x = -1, y = -1;
            for (int i = 0; i < m; i++) {
                x = scan.nextInt(); y = scan.nextInt();
                arr[x].add(y); arr[y].add(x);
            }
            int[] ans = new int[n+1];
            int k = 1;
            Arrays.fill(ans, 1);
            if (m % 2 == 1) {
                k=2;
                boolean oddDeg = false;
                for (int i = 1; i <= n; i++) {
                    if (arr[i].size() % 2 == 1) {
                        ans[i] = 2; oddDeg = true; break;
                    }
                }
                if (!oddDeg) {
                    k = 3;
                    ans[x] = 2; ans[y] = 3;
                }
            }
            System.out.println(k);
            for (int i = 1; i <= n; i++) System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}
