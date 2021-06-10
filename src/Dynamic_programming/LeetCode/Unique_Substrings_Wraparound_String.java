package Dynamic_programming.LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Unique_Substrings_Wraparound_String {
    public static void main(String[] args) {
        System.out.println(findSubstringInWraproundString("abdabcd"));
    }
    private static int findSubstringInWraproundString(String p) {
        if (p.length() == 0 || p.length() == 1) return p.length();
        Map<Character, Integer> map = new HashMap<>();
        int[] dp = new int[p.length()];
        Arrays.fill(dp, 1); map.put(p.charAt(0), 1);
        for (int i = 1; i < dp.length; i++){
            if ((p.charAt(i) == p.charAt(i - 1) + 1) || (p.charAt(i) == 'a' && p.charAt(i - 1) == 'z'))
                dp[i] = dp[i-1] + 1;
            if (map.containsKey(p.charAt(i))){
                int temp = map.get(p.charAt(i));
                map.replace(p.charAt(i), temp, Math.max(temp, dp[i]));
            }else
                map.put(p.charAt(i), dp[i]);
        }
        int sum = 0;
        for (int val: map.values()){
            sum += val;
        }
        return sum;
    }
}
