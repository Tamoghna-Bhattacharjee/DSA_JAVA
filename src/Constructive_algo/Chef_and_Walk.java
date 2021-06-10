package Constructive_algo;

import java.util.Scanner;
// https://www.codechef.com/RC122020/problems/RECNDNUM

/*
    Count the gap of time b/w even-odd and odd-even occurrence
    Then calculate sum by arithmetic progression
*/
public class Chef_and_Walk {
    static long mod = 1000000007;
    public static void main (String[] args) throws java.lang.Exception {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            long n = scan.nextLong();
            long k = scan.nextLong();
            long oe = 0, eo = 0;
            if (k%2==1) {
                oe = k/2; eo = k/2;
            }else {
                oe = k/2; eo = k/2 - 1;
            }
            long s = 0;
            if (n == 0)
                s = oe%mod*2%mod*oe%mod + eo%mod*(2+2*eo)%mod;
            else
                s = n*n%mod + oe%mod*n%mod*2%mod + eo*(eo+1)%mod;
            s = s % mod;
            System.out.println(s);
        }
    }
}
