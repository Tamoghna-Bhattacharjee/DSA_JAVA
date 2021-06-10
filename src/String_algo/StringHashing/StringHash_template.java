package String_algo.StringHashing;

import java.util.Scanner;

public class StringHash_template {
    static long[] hash, pow;
    static long mod = 1000000009;
    static long p = 31;
    static String s;
    // hash[i] the hash of the prefix with i characters
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt(); scan.nextLine();
        while (T-- > 0) {
            s = scan.nextLine();
            init();
            mkHash();
            int Q = scan.nextInt();
            while (Q-- > 0) {
                // one based index
                int L1 = scan.nextInt() - 1, R1 = scan.nextInt() - 1;
                int L2 = scan.nextInt() - 1, R2 = scan.nextInt() - 1;
                long a1 = getRangeHash(L1, R1), a2 = getRangeHash(L2, R2);
                System.out.println(a1 + " " + s.substring(L1, R1+1));
                System.out.println(a2 + " " + s.substring(L2, R2+1));
            }
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
