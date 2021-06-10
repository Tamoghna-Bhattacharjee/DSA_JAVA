package Dynamic_programming.LeetCode;

import java.util.*;
// https://leetcode.com/problems/largest-divisible-subset/

public class Largest_Divisible_Subset {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,6,8};
        System.out.println(largestDivisibleSubset(nums));
    }
    private static List<Integer> largestDivisibleSubset(int[] nums){
        Map<Integer, Set<Integer>> dp = new HashMap<>();
        Arrays.sort(nums);
        for (int n: nums)
            dp.put(n, new HashSet<Integer>(Collections.singleton(n)));

        for (int i = 1; i < nums.length; i++){
            Set<Integer> m = new HashSet<Integer>();
            for (int j = 0; j < i; j++){
                if (nums[i] % nums[j] == 0 && dp.get(nums[j]).size() > m.size()){
                    m = new HashSet<>(dp.get(nums[j]));
                }
            }
            m.add(nums[i]);
            dp.put(nums[i], m);
        }

        Set<Integer> max = new HashSet<Integer>();
        for (int i: dp.keySet()){
            if (dp.get(i).size() > max.size())
                max = dp.get(i);
        }
        return new ArrayList<>(max);
    }
}
