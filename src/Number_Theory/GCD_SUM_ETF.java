package Number_Theory;

// sum(gcd(i, N)) for i = 1 to N
public class GCD_SUM_ETF {
    static int maxN = 1000000;
    static int[] phi = new int[maxN+1];

    public static void main(String[] args) {
        ETF_sieve();
        for (int i = 10; i < 26; i++) System.out.println(getSum(i));
    }
    static int getSum(int n) {
        int res = 0;
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                int d1 = i, d2 = n/i;
                res += d1 * phi[n/d1];
                if (d1 != d2) res += d2 * phi[n/d2];
            }
        }
        return res;
    }
    static void ETF_sieve() {
        for (int i = 1; i <= maxN; i++) phi[i] = i;
        for (int i = 2; i <= maxN; i++) {
            if (phi[i] == i) { // if prime
                for (int j = i; j <= maxN; j+=i) {
                    phi[j] /= i;
                    phi[j] *= (i-1);
                }
            }
        }
    }
}
