package Algorithm.Recurtion;

import java.util.Scanner;

public class All_Possible_Combination {
    public static void main(String[] args) {
        // Given a set of characters and a positive integer k,
        // print all possible strings of length k that can be formed from the given set.

        Scanner scan = new Scanner(System.in);
        char[] ch = {'a' , 'b'};
        System.out.println("Enter the length for the string you wanna create");
        int k = scan.nextInt();
        print_All_Combination(ch , k , "");
    }

    private static void print_All_Combination(char[] ch , int k , String str){

        if(k == 0){
            System.out.println(str);
            return;
        }

        StringBuilder stringBuilder = new StringBuilder(str);

        for(int i = 0; i < ch.length ; i++){
            str = stringBuilder.append(ch[i]).toString();

            print_All_Combination(ch , k - 1 , str);

            //remove the last element to make a new combination
            stringBuilder.setCharAt(str.length() - 1 , Character.MIN_VALUE);
        }
    }
}
