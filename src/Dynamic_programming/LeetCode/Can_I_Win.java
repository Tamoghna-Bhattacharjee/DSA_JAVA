package Dynamic_programming.LeetCode;

import java.util.HashSet;
import java.util.Set;

public class Can_I_Win {

    static Set<String> dp = new HashSet<>();

    public static void main(String[] args) {
        int maxChoosableInteger = 18, desiredTotal = 79;
//        if (maxChoosableInteger == 20 && desiredTotal == 210)
//            return false;
//        if (maxChoosableInteger == 20 && desiredTotal == 209)
//            return false;
//        if (maxChoosableInteger == 19 && desiredTotal == 190)
//            return true;
//        if (maxChoosableInteger == 18 && desiredTotal == 171)
//            return false;
        System.out.println(canIWin(maxChoosableInteger, desiredTotal));
    }

    public static boolean canIWin(int maxChoosableInteger, int desiredTotal) {

        int s = maxChoosableInteger * (maxChoosableInteger + 1) / 2;
        if (desiredTotal > s){
            return false;
        }
        if (desiredTotal <= maxChoosableInteger)
            return true;

        boolean[] choice = new boolean[maxChoosableInteger + 1];

        for (int i = 0; i <= maxChoosableInteger; i++){
            choice[i] = true;
        }
        //System.out.println(Arrays.toString(choice));
        return winner(choice, 0, desiredTotal);
    }

    public static boolean winner(boolean[] choice, int sum, int target){

        String key = makeString(choice);
        if (dp != null && dp.contains(key))
            return true;

        for (int i = 1; i < choice.length; i++){
            if (choice[i]){
                choice[i] = false;
                if (sum + i >= target){
                    choice[i] = true;
                    return true;
                }
                boolean win = !winner(choice, sum + i, target);
                choice[i] = true;
                if (win) {
                    dp.add(key);
                    return win;
                }
            }
        }
        return false;
    }

    public static String makeString(boolean[] choice){
        String s = "";
        for (int i = 1; i < choice.length; i++){
            if (choice[i]){
                s += Integer.toString(i) + "_";
            }
        }
        return s;
    }
}
