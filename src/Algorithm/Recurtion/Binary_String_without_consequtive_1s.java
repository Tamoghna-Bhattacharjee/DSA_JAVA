package Algorithm.Recurtion;

import java.util.ArrayList;
import java.util.Scanner;

public class Binary_String_without_consequtive_1s {
    public static void main(String[] args) {

        //IDEA
//      Idea behind that is IF string ends with ‘1’ then we put only ‘0’ at the end.
//      IF string ends with ‘0’ then we put both ‘0’ and ‘1’ at the end of string
//      for generating new string.

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter bit size and generate all possible combination of bits without " +
                "consecutive 1's");

        int k = scan.nextInt();
        ArrayList<String> res = new ArrayList<>();

        combination(k , "" , true , res);

        System.out.println(res.toString());
    }

    private static void combination(int k , String bits , boolean isEndZero , ArrayList<String> res){

        if(k == 0) {
            res.add(bits);
            return;
        }
        k--;
        if(isEndZero){
            combination(k , bits + "1" , false , res);
            combination(k , bits + "0" , true , res);
        }
        else
            combination(k , bits + "0" , true , res);
    }
}
