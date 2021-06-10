package Algorithm.Recurtion;

import java.util.LinkedList;
import java.util.Scanner;

public class Generate_All_Combination_Of_Number_In_SameOrder {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a number");
        String s = scan.nextLine();

        generateAllCombination(s , new LinkedList<>() , s.length(), 0);

    }
    public static void generateAllCombination(String s , LinkedList<String> current , int len , int start){

        if(start >= len){
            System.out.println(current.toString());
            return;
        }

        for(int i = start ; i < len ; i++){
            String s1 = s.substring(start , i + 1);
            current.add(s1);
            generateAllCombination(s , current , len , i + 1);
            current.removeLast();
        }
    }
}
