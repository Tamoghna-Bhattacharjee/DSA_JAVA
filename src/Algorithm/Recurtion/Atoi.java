package Algorithm.Recurtion;

import java.util.Scanner;

public class Atoi {
    public static void main(String[] args) {
        // The atoi() function takes a string
        // (which represents an integer) as an argument and returns its value.
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a string");
        String str = scan.nextLine();

        int num = atoi(str , str.length() , 0 , 0);
        System.out.println(num);
    }

    private static int atoi(String str , int len , int index , int res){

        if (index == len)
            return res;

        int n = str.charAt(index) - 48;
        res += n * Math.pow(10 , len - index - 1);

        return atoi(str , len , index + 1 , res);

    }
}
