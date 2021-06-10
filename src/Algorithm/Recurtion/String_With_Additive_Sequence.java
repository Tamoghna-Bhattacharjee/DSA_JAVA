package Algorithm.Recurtion;

import java.util.Scanner;

public class String_With_Additive_Sequence {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        System.out.println(isAdditive(str , 0 , false , 0));
    }
    private static boolean isAdditive(String str , int start , boolean flag , int counter){

        if(str.length() < 3){
            System.out.println("Make entry greater than 3");
            return false;
        }

        if(counter >= str.length())
            return flag;

        for(int i = start ; i < str.length(); i++){
            String s1 = str.substring(start , i + 1);
            int n1 = Integer.valueOf(s1);

            for(int j = i + 1 ; j < str.length(); j++){
                String s2 = str.substring(i + 1 , j + 1);
                int n2 = Integer.valueOf(s2);
                int sum = n1 + n2;
                int len = (sum + "").length();

                if(j + 1 + len <= str.length()){
                    if(str.substring(j + 1 , j + 1 + len).equals(sum + "")){
                        //System.out.println(n1 + " + " + n2 + " = " + sum);
                        flag = isAdditive(str , i + 1 , true, j + 1 + len);
                        break;
                    }else
                        flag = false;
                }
            }
            if (flag)
                return true;
        }
        return false;
    }
}
