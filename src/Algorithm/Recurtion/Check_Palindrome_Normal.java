package Algorithm.Recurtion;

import java.util.Scanner;

public class Check_Palindrome_Normal {
    public static void main(String[] args) {
        //recursively check weather a string is palindrome or not;

        Scanner scan = new Scanner(System.in);
        System.out.print("Number = ");
        int num = scan.nextInt();

        System.out.println(isPalindrome(Integer.toString(num) , 0 , Integer.toString(num).length() - 1 , true));
    }

    private static boolean isPalindrome(String num , int start , int end , boolean flag){

        if(start > end || !flag)
            return flag;
        else {
            if(num.charAt(start) != num.charAt(end)){
                return false;
            }else
                return isPalindrome(num , ++start , --end , true);
        }
    }
}
