package Algorithm.Recurtion;

import java.util.ArrayList;
import java.util.Scanner;

public class BinaryNumber_with_equalHalfs {
    public static void main(String[] args) {
        // Given a number n, we need to print all n-digit binary numbers with equal sum in left and right
        // halves. If n is odd, then mid element can be either 0 or 1.Given a number n, we need to print
        // all n-digit binary numbers with equal sum in left and right halves.
        // If n is odd, then mid element can be either 0 or 1.

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter bit size");
        int n = scan.nextInt();

        ArrayList<Integer> res = new ArrayList<>();
        generate(n, res , (int) Math.pow(2, n - 1), (int) Math.pow(2, n) - 1);

        //System.out.println(isEqualHalf("10001", true));
        System.out.println(res.toString());


        /*
        My thought.
        generate all possible combination of binary number with 'n' (it ranges from 2^(n-1) to 2^n - 1)
        check if one char in one half is present in another
        if present : delete both that element and return true and hence it's gets stored in an arraylist
        elss : return false
         */

    }

    private static void generate(int n, ArrayList<Integer> res , int minPossible , int maxPossible){
        if(minPossible > maxPossible)
            return;

        int bin = binary(minPossible);

        if(isEqualHalf(Integer.toString(bin), n % 2 != 0))
            res.add(bin);

        generate(n , res , ++minPossible , maxPossible);
    }

    private static boolean isEqualHalf(String s, boolean isOdd){
        //if odd then mid char is exclusive else inclusive
        if(s.equals("") || s.length() == 1)
            return true;

        int mid = isOdd ? (s.length() - 1)/2 + 1 : s.length()/2;

        StringBuilder stringBuilder = new StringBuilder(s);

        if(s.substring(mid, s.length()).indexOf(s.charAt(0)) >= 0){
            int index = s.substring(mid).indexOf(s.charAt(0));
            index += mid;

            s = stringBuilder.deleteCharAt(index).toString();
            //System.out.println(s);

            s = stringBuilder.deleteCharAt(0).toString();
            //System.out.println(s + " index = " + index);

            return isEqualHalf(s , isOdd);
        }
        else
            return false;
    }

    private static int binary(int n){
        if(n > 0)
            return n % 2 + binary(n/2) * 10;
        else
            return 0;
    }
}
