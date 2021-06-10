package String_algo.StringHashing.Chef_Force;
import java.util.Arrays;
import java.util.Scanner;
// https://codeforces.com/problemset/problem/126/B

public class Password {
    static long[] hash, pow;
    static int[] dp;
    static long mod = 1000000007, p = 31;
    static String s;
    static int n;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        s = scan.nextLine();
        mkHash();
        dp = new int[n];
        Arrays.fill(dp, -1);
        divideConq(1, n-2);
        int ans = 0;
        for (int i = 0; i < n; i++)
            if (dp[i] == 1) ans = Math.max(ans, i);
        if (ans == 0) System.out.println("Just a legend");
        else System.out.println(s.substring(0, ans));
    }
    static int isValid(int x) {
        long a = getRangeHash(0, x-1);
        long b = getRangeHash(n-x, n-1);
        if (a == b) {
            for (int i = 1; i+x-1 < n-1; i++) {
                if (a == getRangeHash(i, i+x-1)) return 1;
            }
            return 0;
        }else return -1;
    }

    static void divideConq(int L, int R) {
        if (L > R) return;
        int mid = (L+R)/2;
        if (dp[mid] != -1) return;
        dp[mid] = isValid(mid);
        if (dp[mid] == 1) divideConq(mid+1, R);
        else {
            divideConq(L, mid-1);
            divideConq(mid+1, R);
        }
    }

    static void mkHash() {
        n = s.length();
        hash = new long[n+1]; pow = new long[n+1];
        pow[0] = 1;
        for (int i = 0; i < n; i++) {
            hash[i+1] = (hash[i] + (s.charAt(i) - 'a' + 1) * pow[i]) % mod;
            pow[i+1] = pow[i] * p % mod;
        }
    }
    static long getRangeHash(int L, int R) {
        return (hash[R+1] - hash[L] + mod)*pow[n-L-1] % mod;
    }
}