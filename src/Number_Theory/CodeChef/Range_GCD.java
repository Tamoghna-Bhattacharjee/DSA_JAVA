package Number_Theory.CodeChef;
import java.util.Scanner;
// https://www.codechef.com/problems/GCDQ
public class Range_GCD {
    static int[] arr, pre, suf;
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            int n =  scan.nextInt(), Q =  scan.nextInt();
            arr = new int[n];
            pre = new int[n]; suf = new int[n];
            for (int i = 0; i < n; i++) arr[i] =  scan.nextInt();
            f(n);
            while (Q-- > 0) {
                int l =  scan.nextInt()-1, r =  scan.nextInt()-1;
                int x = l-1 >= 0? pre[l-1]: 0;
                int y = r+1 < n? suf[r+1]: 0;
                if (x == 0 && y == 0) System.out.println(0);
                else if (x == 0) System.out.println(y);
                else if (y == 0) System.out.println(x);
                else System.out.println(gcd(x, y));
            }
        }
    }
    // mk pre and suf
    static void f(int n) {
        pre[0] = arr[0];
        for (int i = 1; i < n; i++) pre[i] = gcd(pre[i-1], arr[i]);

        suf[n-1] = arr[n-1];
        for (int i = n-2; i >= 0; i--) suf[i] = gcd(suf[i+1], arr[i]);

    }
    public static int gcd(int a, int b) {
        if (b==0) return a;
        return gcd(b, a % b);
    }
}
