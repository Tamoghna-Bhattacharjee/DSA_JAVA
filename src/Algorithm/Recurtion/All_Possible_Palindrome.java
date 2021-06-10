package Algorithm.Recurtion;

import java.util.LinkedList;
import java.util.Scanner;

public class All_Possible_Palindrome {
    public static void main(String[] args) {

        //Given a string, find all possible palindromic partitions of given string.

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter String : ");
        String str = scan.nextLine();

        LinkedList<String> current = new LinkedList<>();

        allPalComb(str , current , str.length() , 0);

    }

    private static void allPalComb(String s , LinkedList<String> current , int len , int start){

        if(start >= len){
            System.out.println(current.toString());
            return;
        }

        for(int i = start ; i < len ; i++){
            String s1 = s.substring(start , i + 1);

            //check if s1 is palindrome :: if yes see the next combo after that
            if(isPalindrome(s1 , 0 , s1.length() - 1)){
                current.add(s1);
                allPalComb(s , current , len , i + 1);
                current.removeLast();
            }
        }

    }

    private static boolean isPalindrome(String s , int strat , int end){
        if(s.length() == 1)
            return true;

        boolean ispallindrome = true;
        while(strat < end){
            if(s.charAt(strat) != s.charAt(end)){
                ispallindrome = false;
                break;
            }
            strat++;
            end--;
        }
        return ispallindrome;
    }
}
