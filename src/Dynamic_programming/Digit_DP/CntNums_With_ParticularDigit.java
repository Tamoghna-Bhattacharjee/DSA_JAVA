package Dynamic_programming.Digit_DP;

import java.util.Scanner;

public class CntNums_With_ParticularDigit {
    public static long[] cnt, p;
    public static void main(String[] args) {
        init();
        Scanner scan = new Scanner(System.in);
        long n = scan.nextLong();
        long digit = scan.nextLong();
        System.out.println(countNumbersWith_K(n, digit));
    }

    public static long countNumbersWith_K(long n, long digit) {
        if (n < 4) return 0;
        if (n < 10) return 1;
        int d = (int) Math.log10(n);
        long msd = n/p[d];
        if (msd == digit) return msd * cnt[d] + n % p[d] + 1;
        else if (msd > digit) return (msd-1)*cnt[d] + p[d] + countNumbersWith_K(n%p[d], 4);
        else return (msd)*cnt[d] + countNumbersWith_K(n%p[d], 4);
    }

    public static void init() {
        cnt = new long[19];
        p = new long[19]; p[0] = 1;
        // computing count of numbers with 4 in it from 1 to 10^d,
        // d=0 cnt[0] = 0;
        // d=1 cnt[1] = count of numbers from 1 to 10 = 1
        // d=2 cnt[2] = count of numbers from 1 to 100 = cnt[1]*9 + 10 = 19
        // d=3 cnt[3] = count of numbers from 1 to 1000 = cnt[2]*19 + 100 = 17
        for (int i = 1; i <= 18; i++) {
            cnt[i] = 9 * cnt[i-1] + p[i-1];
            p[i] = p[i-1] * 10;
        }
    }
}
