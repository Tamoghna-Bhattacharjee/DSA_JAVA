package Dynamic_programming.LeetCode;

import java.util.*;

public class Word_Break_II {
    static HashMap<String, List<String>> map = new HashMap<>();
    public static void main(String[] args) {
        List<String> words = new LinkedList<>(Arrays.asList("cats", "dog", "sand", "and", "cat"));
        System.out.println(wordBreak("catsanddog", words));
    }
    public static List<String> wordBreak(String s, List<String> wordDict) {
        if (s.length() == 0 || wordDict.size() == 0) return new ArrayList<>();
        return util(s, wordDict);
    }
    public static List<String> util(String s, List<String> words) {
        List<String> res = new ArrayList<>();
        if (s.isEmpty()) return res;
        if (map.containsKey(s)) return map.get(s);

        for (String word: words) {
            if (s.equals(word)) {
                res.add(word);
            }else if (s.startsWith(word)) {
                List<String> rem = util(s.substring(word.length()), words);
                for (String remaining: rem){
                    res.add(word + " " + remaining);
                }
            }
        }
        map.put(s, res);
        return res;
    }
}
