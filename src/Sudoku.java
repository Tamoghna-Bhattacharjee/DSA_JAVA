import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Sudoku {
    static int[][] B;
    public static void main(String[] args) {
        B = new int[9][9];
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++) B[i][j] = scan.nextInt();
        fill(0,0);
        for (int[] i: B) System.out.println(Arrays.toString(i));
    }
    public static boolean fill(int i, int j) {
        if (i == 9 && j == 0) return true;
        if (j == 9) return fill(i+1, 0);
        if (B[i][j] != 0) return fill(i, j+1);
        Set<Integer> s = mkset(i, j);
        if (s.size() == 0) return false;
        for (int num: s) {
            B[i][j] = num;
            boolean flag = fill(i, j+1);
            if (flag) return true;
            else {
                B[i][j] = 0;
            }
        }
        return false;
    }
    public static Set<Integer> mkset(int i, int j) {
        Set<Integer> s = new HashSet<>();
        for (int k = 1; k <= 9; k++) s.add(k);
        for (int k = 0; k < 9; k++) {
            s.remove(B[i][k]); s.remove(B[k][j]);
        }
        int k = (i/3) * 3, v = (j/3) * 3;
        for (int c1 = 0; c1 < 3; c1++) {
            for (int c2 = 0; c2 < 3; c2++) {
                s.remove(B[k+c1][v+c2]);
            }
        }
        return s;
    }
}
