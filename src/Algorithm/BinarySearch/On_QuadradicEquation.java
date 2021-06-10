package Algorithm.BinarySearch;

import java.util.Scanner;

// Find me the least non-negative integer Xo, that shall make my value atleast K i.e.,
// A * Xo^2 + B * Xo + C >= K
// 1 <= A, B, C <= 10**5
// 1 <= k <= 10**10

public class On_QuadradicEquation {
    static long a, b, c;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            a = scan.nextLong(); b = scan.nextLong(); c = scan.nextLong();
            long k = scan.nextLong();
            System.out.println(BSearch(k));
        }
    }
    static long F(long x) {
        return a*x*x + b*x + c;
    }
    static long BSearch(long k) {
        if (c >= k) return 0;
        long L = 0, R = (long) Math.ceil(Math.sqrt(k));
        long ans = R;
        while (L <= R) {
            long mid = (L+R) / 2;
            if (F(mid) >= k) {
                ans = Math.min(ans, mid); R = mid-1;
            } else L = mid+1;
        }
        return ans;
    }
}
