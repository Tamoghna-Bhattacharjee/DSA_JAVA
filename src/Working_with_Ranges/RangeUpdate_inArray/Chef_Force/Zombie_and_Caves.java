package Working_with_Ranges.RangeUpdate_inArray.Chef_Force;

import java.util.Arrays;
import java.util.Scanner;
// https://www.codechef.com/AUG19B/problems/ZOMCAV
public class Zombie_and_Caves {
    static int[] radPow, zombie, change;
    public static void main (String[] args) throws java.lang.Exception {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            int n = scan.nextInt();
            radPow = new int[n+1]; zombie = new int[n+1]; change = new int[n+1];
            for (int i = 1; i <= n; i++) radPow[i] = scan.nextInt();
            for (int i = 1; i <= n; i++) zombie[i] = scan.nextInt();

            for (int i = 1; i <= n; i++) update(i-radPow[i], i+radPow[i]);
            for (int i = 1; i <= n; i++) change[i] += change[i-1];
            Arrays.sort(zombie); Arrays.sort(change);
            boolean isDead = true;
            for (int i = 1; i <= n; i++) {
                if (change[i] != zombie[i]) {
                    isDead = false; break;
                }
            }
            System.out.println((isDead? "YES": "NO"));
        }
    }
    static void update(int L, int R) {
        if (L >= 1) change[L]++;
        else change[1]++;
        if (R+1 < change.length) change[R+1]--;
    }
}
