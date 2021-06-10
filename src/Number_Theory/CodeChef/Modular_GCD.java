package Number_Theory.CodeChef;
import java.util.Scanner;

public class Modular_GCD {
    static long mod = (int) Math.pow(10, 9) + 7;
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            long a = scan.nextLong(), b = scan.nextLong(), n = scan.nextLong();
            System.out.println(GCD(a, b, n));
        }
    }
    static long power(long a, long n , long d){
        long res = 1;
        while(n > 0){
            if(n % 2 == 1) res = ((res % d) * (a % d)) % d;
            a = ((a % d) * (a % d)) % d;
            n /= 2;
        }
        return res;
    }

    static long GCD(long a , long b , long n){
        if(a == b){
            return (power(a , n , mod) + power(b , n , mod)) % mod;
        }
        long g = 1;
        long ab = Math.abs(a - b);
        for(long i = 1; i * i <= ab; i++) {
            if(ab % i == 0){
                long tmp = (power(a , n , i) + power(b , n , i)) % i;
                if(tmp == 0) g = Math.max(g , i);
                tmp = (power(a , n , ab/i) + power(b , n , ab/i)) % (ab/i);
                if(tmp == 0) g = Math.max(g , ab / i);
            }
        }
        return g % mod;
    }
}
