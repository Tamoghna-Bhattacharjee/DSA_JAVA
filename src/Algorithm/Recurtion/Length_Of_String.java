package Algorithm.Recurtion;

import java.util.Scanner;

public class Length_Of_String {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a String");
        String s = scan.nextLine();
        int len = length(s);
        System.out.println(len);
    }
    private static int length(String s){
        if (s.equals(""))
            return 0;
        else
            return 1 + length(s.substring(1));
    }
}
