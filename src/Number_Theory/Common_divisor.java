package Number_Theory;

import java.io.*;
import java.util.*;

// https://www.codechef.com/problems/QNUMBER

public class Common_divisor {
    static Map<Long, Integer> primeFactorN;
    static long totalDivisor;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        long N = scan.nextLong(); primeFactorisationN(N);
        int Q = scan.nextInt();
        StringBuilder builder = new StringBuilder();
        while (Q-- > 0) {
            int T = scan.nextInt();
            long k = scan.nextLong();
            if (T == 1) {
                builder.append(getCommonDivisor(k)).append("\n");
            } else {
                long res = getDivisorDivisible_byK(k);
                if (T == 2) builder.append(res).append("\n");
                else builder.append(totalDivisor-res).append("\n");
            }
        }
        PrintWriter wr = new PrintWriter(System.out);
        wr.print(builder);
        wr.flush();
    }
    static long getDivisorDivisible_byK(long k) {
        long res = 1;
        for (Map.Entry<Long, Integer> i: primeFactorN.entrySet()) {
            long key = i.getKey();
            int val = i.getValue();
            int cnt = 0;
            if (k % key == 0) {
                while (k % key == 0) {
                    k /= key; cnt++;
                }
                if (cnt > val) return res = 0;
            }
            res *= (val - cnt + 1);
        }
        if (k > 1) return res = 0;
        return res;
    }
    static long getCommonDivisor(long k) {
        long commonDivisor = 1;
        for (Map.Entry<Long, Integer> i: primeFactorN.entrySet()) {
            long key = i.getKey();
            if (k % key == 0) {
                int cnt = 0;
                while (k % key == 0) {
                    k /= key; cnt++;
                }
                commonDivisor *= (Math.min(i.getValue(), cnt)+1);
            }
        }
        return commonDivisor;
    }
    static void primeFactorisationN (long N) {
        primeFactorN = new HashMap<>();
        totalDivisor = 1;
        for (long i = 2; i*i <= N; i++) {
            if (N % i == 0) {
                int cnt = 0;
                while (N % i == 0) {
                    N /= i; cnt++;
                }
                primeFactorN.put(i, cnt);
                totalDivisor *= (cnt+1);
            }
        }
        if (N > 1) {
            primeFactorN.put(N, 1); totalDivisor *= 2;
        }
    }
}
