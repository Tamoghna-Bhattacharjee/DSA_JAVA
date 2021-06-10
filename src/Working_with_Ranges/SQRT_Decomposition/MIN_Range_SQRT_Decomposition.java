package Working_with_Ranges.SQRT_Decomposition;

import java.util.Scanner;

public class MIN_Range_SQRT_Decomposition {
    static int[] arr, F;
    static int blk; // blk -> Block
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        blk = (int) Math.floor(Math.sqrt(n));
        arr = new int[n];
        F = new int[n/blk + 1];
        for (int i = 0; i < n; i++) arr[i] = scan.nextInt();
        makeSQRTdecomposition(n);
//        System.out.println(Arrays.toString(arr));
//        System.out.println(Arrays.toString(F));
        int Q = scan.nextInt();
        while (Q-- > 0) {
            int l = scan.nextInt(), r = scan.nextInt();
            System.out.println(getMin(l, r));
        }
    }
    static int getMin(int l, int r) {
        int LB = l / blk, RB = r/blk;
        int min = Integer.MAX_VALUE;

        if (LB == RB)
            for (int i = l; i <= r; i++) min = Math.min(min, arr[i]);
        else {
            for (int i = l; i < blk*(LB + 1); i++) min = Math.min(min, arr[i]);
            for (int i = LB+1; i < RB; i++) min = Math.min(min, F[i]);
            for (int i = blk*RB; i <= r; i++) min = Math.min(min, arr[i]);
        }
        return min;
    }
    static void makeSQRTdecomposition(int n) {
        for (int i = 0; i < n; i+=blk) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < blk && i+j < n; j++) {
                min = Math.min(min, arr[i+j]);
            }
            F[i/blk] = min;
        }
    }
}
