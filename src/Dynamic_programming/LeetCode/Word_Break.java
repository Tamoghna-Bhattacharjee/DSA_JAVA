package Dynamic_programming.LeetCode;

import java.util.*;

public class Word_Break {
    public static void main(String[] args) {
        List<String> words = new LinkedList<>(Arrays.asList("cats", "dog", "sand", "and", "cat"));
        System.out.println(wordBreak_topDown("catsandog", words));
    }
    private static boolean wordBreak_topDown(String s, List<String>wordDict){
        if (s.length() == 0) return false;
        if (s.length() != 0 && wordDict.size() == 0) return false;

        boolean[] dp = new boolean[s.length() + 1];
        HashMap<Integer, HashSet<String>> dict = new HashMap<>();
        for (String str: wordDict){
            HashSet<String> set = dict.getOrDefault(str.length(), new HashSet<>());
            set.add(str);
            dict.put(str.length(), set);
        }
        dp[s.length()] = true;

        for (int i = s.length(); i >= 1; i--){
            if (dp[i]){
                for (Map.Entry<Integer, HashSet<String>> d: dict.entrySet()){
                    int start = i - d.getKey();
                    if (start >= 0){
                        if (d.getValue().contains(s.substring(start, i)))
                            dp[start] = true;
                    }
                }
            }
        }
        return dp[0];

    }
}
