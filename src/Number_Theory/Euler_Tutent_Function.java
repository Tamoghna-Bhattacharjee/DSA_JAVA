package Number_Theory;

public class Euler_Tutent_Function {
    static int maxN = 1000000;
    static int[] phi = new int[maxN+1];
    public static void main(String[] args) {
        ETF_sieve();
        System.out.println(ETF_naive(27));
        System.out.println(phi[27]);
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
    static int ETF_naive(int n) {
        // O(sqrt(n))
        int res = n;
        for (int i = 2; i*i <= n; i++) {
            if (n%i == 0) {
                res /= i;
                res *= (i-1);
                while (n % i == 0) n/=i;
            }
        }
        if (n > 1) {
            res /= n; res *= (n-1);
        }
        return res;
    }
}
