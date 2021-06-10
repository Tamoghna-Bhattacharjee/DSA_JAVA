package Algorithm.BinarySearch;

import java.util.Scanner;

public class TernaryString {
    static String s;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt(); scan.nextLine();
        while (T-- > 0) {
            s = scan.nextLine();
            System.out.println(BSearch(s));
        }
    }
    static int BSearch(String s) {
        int L = 3, R = s.length();
        int ans = Integer.MAX_VALUE;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (isValid(mid)) {
                ans = Math.min(ans, mid); R = mid-1;
            } else L = mid + 1;
        }
        return ans > s.length()? 0: ans;
    }
    static boolean isValid(int x) {
        int[] freq = {0,0,0,0};
        for (int i = 0; i < x; i++) freq[s.charAt(i)-48]++;
        for (int i = x; i < s.length(); i++) {
            if (freq[1] >= 1 && freq[2] >= 1 && freq[3] >= 1) return true;
            freq[s.charAt(i)-48]++;
            freq[s.charAt(i-x)-48]--;
        }
        return freq[1] >= 1 && freq[2] >= 1 && freq[3] >= 1;
    }
}
