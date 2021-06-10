package Constructive_algo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
// https://www.codechef.com/COOK117B/problems/TOWCNT

public class TowerCounting {
    public static void main (String[] args) throws java.lang.Exception {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            int h = scan.nextInt(), n = scan.nextInt();
            Point[] arr = new Point[n];
            for (int i = 0; i < n; i++) {
                arr[i] = new Point(scan.nextInt(), scan.nextInt(), scan.nextInt(), i);
            }
            Arrays.sort(arr, new Comparator<Point>() {
                @Override
                public int compare(Point p1, Point p2) {
                    return p1.x-p2.x;
                }
            });
            int[] ans = new int[n];
            for (int i = 0; i < n-1; i++) {
                long slope0_n=0, slope0_d=0, slope1_n=0, slope1_d=0;
                boolean z = false, o = false; // z -> slope0 isCalculated, o->slope1 isCalculated
                long y1 = arr[i].a, x1 = arr[i].x;
                if (arr[i+1].t == 0) {
                    z = true;
                    slope0_n = arr[i+1].a - y1; slope0_d = arr[i+1].x - x1;
                }else {
                    o = true;
                    slope1_n = arr[i+1].a - y1; slope1_d = arr[i+1].x - x1;
                }
                ans[arr[i].i]++; ans[arr[i+1].i]++;
                for (int j = i+2; j < n; j++) {
                    long y2 = arr[j].a, x2 = arr[j].x;
                    long nume = y2-y1, deno = x2 - x1;
                    int t = arr[j].t;
                    if (z && o) {
                        if (nume*slope0_d > deno*slope0_n && nume*slope1_d < deno*slope1_n) {
                            ans[arr[i].i]++; ans[arr[j].i]++;
                        }
                    }else if (z) {
                        if (nume*slope0_d > deno*slope0_n) {
                            ans[arr[i].i]++; ans[arr[j].i]++;
                        }
                    }else if (o) {
                        if (nume*slope1_d < deno*slope1_n) {
                            ans[arr[i].i]++; ans[arr[j].i]++;
                        }
                    }
                    if (t == 0) {
                        if (!z) {
                            z = true;
                            slope0_n = nume; slope0_d = deno;
                        }else if (nume*slope0_d > deno*slope0_n) {
                            slope0_n = nume; slope0_d = deno;
                        }
                    }else {
                        if (!o) {
                            o=true;
                            slope1_n = nume; slope1_d = deno;
                        }else if(nume*slope1_d < deno*slope1_n) {
                            slope1_n = nume; slope1_d = deno;
                        }
                    }
                }

            }
            for (int i: ans) System.out.print(i + " ");
            System.out.println();
        }
    }
    static class Point {
        int t, x, a, i;
        public Point(int t, int x, int a, int ind) {
            this.t = t;
            this.x = x;
            this.a = a;
            this.i = ind;
        }
    }
}
