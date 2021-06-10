package Combinatorics;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// https://www.codechef.com/LTIME83B/problems/MEXUM

public class Positive_Mex {
    static long mod = 998244353;
    public static void main (String[] args) throws java.lang.Exception {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            int n = scan.nextInt();
            int[] arr = new int[n];
            Map<Integer, Integer> freq = new HashMap<>();
            for (int i = 0; i < n; i++) {
                arr[i] = scan.nextInt();
                freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
            }
            freq.put(0, 1);
            long sum = 0;
            long prev = 1;
            int cnt = 0;
            for (int i = 1; i <= n; i++) {
                if (!freq.containsKey(i)) {
                    long r = power(2, n-cnt) % mod;
                    prev = prev * (power(2, freq.get(i-1)) - 1) % mod;
                    sum = (sum + i%mod*r%mod*prev%mod)%mod;
                    break;
                }
                cnt += freq.get(i);
                long r = power(2, n-cnt) % mod;
                prev = prev * (power(2, freq.get(i-1)) - 1) % mod;
                sum = (sum + i%mod*r%mod*prev%mod)%mod;
            }
            System.out.println(sum);
        }
    }
    static long power(long a, int n) {
        long res = 1;
        while (n > 0) {
            if (n % 2 == 1) res = (res * a) % mod;
            a = (a * a) % mod;
            n /= 2;
        }
        return res;
    }
}
