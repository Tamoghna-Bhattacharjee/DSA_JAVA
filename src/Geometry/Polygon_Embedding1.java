package Geometry;

// https://codeforces.com/contest/1354/problem/C1

import java.util.Scanner;

public class Polygon_Embedding1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            int m = scan.nextInt();
            if (m % 2 == 0) System.out.println(type1(2*m));
            else System.out.println(type2(2*m));
        }
    }
    static double type1(int n) {
        return 1 / Math.tan(Math.toRadians(180.0/n));
    }
    static double type2 (int n) {
        return Math.cos(Math.toRadians(180.0/(2*n))) / Math.sin(Math.toRadians(180.0/n));
    }
}
