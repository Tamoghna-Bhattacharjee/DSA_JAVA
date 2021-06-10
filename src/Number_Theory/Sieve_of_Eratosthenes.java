package Number_Theory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Sieve_of_Eratosthenes {
    static boolean[] isPrime;
    static int maxN = 16000000; // limit till 10^6-th prime
    static List<Integer> primes;

    public static void main(String[] args) throws IOException {
        isPrime = new boolean[maxN+1];
        primes = new ArrayList<>();
        sieve();
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            int k = scan.nextInt();
            System.out.println(primes.get(k-1));
        }
    }

    private static void sieve() {
        // prime-> true, composite->false
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i*i <= maxN; i++) {
            if (isPrime[i]) {
                for (int j = i*i; j <= maxN; j+=i) isPrime[j] = false;
            }
        }
        for (int i = 2; i <= maxN; i++) {
            if (isPrime[i]) primes.add(i);
        }
    }
}
