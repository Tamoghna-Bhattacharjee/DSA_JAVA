package Number_Theory.CodeChef;

import java.util.Scanner;
// https://www.codechef.com/WCS2019/problems/WCSE
public class Prime_Factor_and_Ranges {
    static int[] pfs;
    static int[][] ps;
    static int maxN = 1000000;
    public static void main (String[] args) throws java.lang.Exception
    {
        pfs = new int[maxN+1];
        ps = new int[11][maxN+1];
        sieve();
        cpf();
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            int l = scan.nextInt(), r = scan.nextInt(), k = scan.nextInt();
            if (k > 10) System.out.println(0);
            else System.out.println(ps[k][r] - ps[k][l-1]);
            //System.out.println(Arrays.toString(ps[k]));
        }
    }
    static void sieve() {
        for (int i = 2; i <= maxN; i++) {
            if (pfs[i] == 0) { // i is prime
                for (int j = i; j <= maxN; j+=i) {
                    pfs[j]++;
                }
            }
        }
    }
    static void cpf() {
        for (int k = 0; k <= 10; k++) {
            for (int i = 1; i<=maxN; i++)
                ps[k][i] = ps[k][i-1] + (pfs[i]==k? 1: 0);
        }
    }
}
