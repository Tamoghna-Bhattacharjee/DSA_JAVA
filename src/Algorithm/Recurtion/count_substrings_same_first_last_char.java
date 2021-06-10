package Algorithm.Recurtion;

public class count_substrings_same_first_last_char {
    public static void main(String[] args) {
        String str = "aba";
        System.out.println(countSubString(str , 0 , 0) + str.length());
    }
    private static int countSubString(String str , int count , int strat ){

        for(int i = strat ; i < str.length() ; i++){

            if(isSameFirstLastChar(str.substring(strat , i + 1)) && i + 1 - strat > 1){

                System.out.println(str.substring(strat , i + 1));
                count = countSubString(str , ++count , i+1);

            }else
                count = countSubString(str , count , i+1);
        }
        return count;
    }
    private static boolean isSameFirstLastChar(String s){
        return s.charAt(0) == s.charAt(s.length() - 1);
    }
}
