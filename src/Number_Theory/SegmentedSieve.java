package Number_Theory;

import java.util.ArrayList;
import java.util.Scanner;

public class SegmentedSieve {
    static long N = 1000000000;
    static int lm = (int) (Math.sqrt(N)+1);
    static int[] simpleSieve, segSieve;
    static ArrayList<Integer> simplePrime;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        makeSimpleSieve();
        while (T-- > 0) {
            long l = scan.nextLong(), r = scan.nextLong();
            mkSegmentSieve(l, r);
        }
    }
    static void mkSegmentSieve(long L, long R) {
        int len = (int) (R-L+1);
        segSieve = new int[len];
        for (long p: simplePrime) {
            if (p*p > R) break;
            long i = (L/p)*p;
            if (i < L) i += p;
            while (i <= R) {
                if (i != p) segSieve[(int)(i-L)] = 1;
                i += p;
            }
        }
        for (long i = L; i <= R; i++)
            if (i != 1 && segSieve[(int)(i-L)] == 0) System.out.println(i);

    }

    static void makeSimpleSieve(){
        // 0->prime 1->co-prime
        simpleSieve = new int[lm+1];
        simplePrime = new ArrayList<>();
        for (int i = 2; i*i <= lm; i++) {
            if (simpleSieve[i] == 0) {
                for (int j = i*i; j <= lm; j+=i) simpleSieve[j] = 1;
            }
        }
        for (int i = 2; i <= lm; i++) {
            if (simpleSieve[i] == 0) simplePrime.add(i);
        }
    }
}
