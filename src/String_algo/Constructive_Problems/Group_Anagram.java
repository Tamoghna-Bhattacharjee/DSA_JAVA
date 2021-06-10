package String_algo.Constructive_Problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
// Given an array of strings, group anagrams together.
//Example:
//Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
//Output:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//]
public class Group_Anagram {
    public static void main(String[] args) {
        String[] s = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(s));
        System.out.println(groupAnagramsBetter(s));
    }
    static public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        int n = strs.length;
        int[][] mat = new int[n][26];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < strs[i].length(); j++) {
                mat[i][strs[i].charAt(j)-97]++;
            }
        }

        boolean[] isok = new boolean[n];
        for (int i = 0; i < n; i++) {
            List<String> temp = new ArrayList<>();
            if (!isok[i]) {
                //System.out.println(Arrays.toString(isok) + " " + i);
                temp.add(strs[i]);
                for (int j = i+1; j < n; j++) {
                    if (strs[i].length() != strs[j].length() || isok[j]) continue;
                    isok[j] = true;
                    for (int k = 0; k < strs[j].length(); k++) {
                        int ind = strs[j].charAt(k) - 97;
                        isok[j] = isok[j] && mat[i][ind] == mat[j][ind];
                        if (!isok[j]) break;
                    }
                    if (isok[j]) temp.add(strs[j]);
                }
                res.add(temp);
            }
        }
        return res;
    }
    static public List<List<String>> groupAnagramsBetter(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str: strs) {
            char[] toBeSorted = str.toCharArray();
            Arrays.sort(toBeSorted);
            String key = new String(toBeSorted);
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }
        }
        return new ArrayList<>(map.values());
    }

}
