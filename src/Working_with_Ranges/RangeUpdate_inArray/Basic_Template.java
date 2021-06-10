package Working_with_Ranges.RangeUpdate_inArray;

import java.util.Arrays;
import java.util.Scanner;

public class Basic_Template {
    static int[] updateArr, arr;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(), q = scan.nextInt();
        arr = new int[n+1]; updateArr = new int[n+1];
        while (q-- > 0) {
            int L = scan.nextInt(), R = scan.nextInt();
            update(L, R);
        }
        // prefix sum
        for (int i = 1; i <= n; i++) updateArr[i] += updateArr[i-1];
        System.out.println(Arrays.toString(updateArr));
    }
    static void update(int L, int R) {
        if (L >= 1) updateArr[L]++;
        else updateArr[1]++;
        if (R+1 < updateArr.length) updateArr[R+1]--;
    }
}
