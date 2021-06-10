package Arrays_algo.Kadane_Algo;

import java.util.ArrayList;
import java.util.Scanner;

// https://codeforces.com/contest/1370/problem/E

public class Binary_Subsequence_Rotation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(); scan.nextLine();
        String s = scan.nextLine(), t = scan.nextLine();
        ArrayList<Integer> a1 = new ArrayList<>(), a2 = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                if (s.charAt(i) == '1') {
                    sum++; a1.add(1); a2.add(-1);
                } else {
                    sum--; a1.add(-1); a2.add(1);
                }
            }
        }
        if (sum != 0) {
            System.out.println(-1);
        } else {
            System.out.println(Math.max(kadaneAlgo(a1), kadaneAlgo(a2)));
        }

    }
    static int kadaneAlgo(ArrayList<Integer> arr) {
        if (arr.size() == 0) return 0;
        int mxh, msf;
        mxh = msf = arr.get(0);
        for (int i = 1; i < arr.size(); i++) {
            mxh = Math.max(arr.get(i), arr.get(i) + mxh);
            msf = Math.max(msf, mxh);
        }
        return msf;
    }
}
