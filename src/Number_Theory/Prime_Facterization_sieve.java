package Number_Theory;

import java.util.HashMap;
import java.util.Map;

public class Prime_Facterization_sieve {
    static int[] spf;
    static int maxN = 1000000;
    public static void main (String[] args) {
        spf = new int[maxN+1];
        sieve(); // O(N * log(logN))
        primeFactorSet(83360); // O(logN)
        naieve_approach(83360); // O(N*(1/2))
    }
    static void sieve() {
        // init smallest prime factor to be itself
        for (int i = 2; i <= maxN; i++) spf[i] = i;
        // prime factor of all even number is 2
        for (int i = 2; i <= maxN; i+=2) spf[i] = 2;

        for (int i = 3; i*i <= maxN; i++) {
            if (spf[i] == i) {
                // i is prime
                for (int j = i; i*j <= maxN; j+=2) {
                    if (spf[i*j] == i*j) spf[i*j] = i;
                }
            }
        }
    }
    static void primeFactorSet(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        while (n > 1) {
            map.put(spf[n], map.getOrDefault(spf[n], 0) + 1);
            n /= spf[n];
        }
        System.out.println(map);
    }

    static void naieve_approach(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                while (n % i == 0) {
                    System.out.print(i + " ");
                    n /= i;
                }
            }
        }
        if (n > 2) System.out.print(n);
    }
}
