package Arrays_algo;

import java.util.*;

public class Word_Ladder_II {
    static List<List<String>> res = new ArrayList<>();
    static Set<String> dictionary;
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> list = new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));
        System.out.println(findLadders(beginWord, endWord, list));
    }
    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        dictionary = new HashSet<>(wordList);
        return res;
    }
}
