package String_algo.StringHashing.Chef_Force;

import java.util.Scanner;
// https://www.codechef.com/COOK118B/problems/CHEFSHIP

public class DivideIn4 {
    static long[] hash, pow;
    static long mod = 1000000009;
    static long p = 31;
    static String s;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt(); scan.nextLine();
        while (T-- > 0) {
            s = scan.nextLine();
            init();
            mkHash();
            int n = s.length();
            int cnt = 0;
            for (int i = 1; i < n - 2; i+=2) {
                int part1L = 0, part1R = i/2;
                int part2L = i/2+1, part2R = i;
                int part3L = part2R+1, part3R = (i+n-1)/2;
                int part4L = part3R+1, part4R = n-1;
                if (getRangeHash(part1L, part1R) == getRangeHash(part2L, part2R)
                        && getRangeHash(part3L, part3R) == getRangeHash(part4L, part4R))
                    cnt++;
            }
            System.out.println(cnt);
        }
    }

    static long getRangeHash(int L, int R) {
        int n = s.length();
        return (hash[R+1] - hash[L] + mod)*pow[n-L-1] % mod;
    }
    static void mkHash() {
        for (int i = 0; i < s.length(); i++) {
            hash[i+1] = (hash[i] + (s.charAt(i) - 'a' + 1) * pow[i]) % mod;
            pow[i+1] = pow[i] * p % mod;
        }
    }
    static void init() {
        int n = s.length();
        hash = new long[n+1];
        pow = new long[n+1];
        pow[0] = 1;
    }
}
