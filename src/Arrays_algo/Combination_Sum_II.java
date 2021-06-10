package Arrays_algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Given a collection of candidate numbers (candidates) and a target number (target),
//find all unique combinations in candidates where the candidate numbers sums to target.
//Each number in candidates may only be used once in the combination.

//Note:
//All numbers (including target) will be positive integers.
//The solution set must not contain duplicate combinations.

//Example 1:
//Input: candidates = [10,1,2,7,6,1,5], target = 8,
//A solution set is:
//[[1, 7], [1, 2, 5], [2, 6], [1, 1, 6]]


public class Combination_Sum_II {
    static List<List<Integer>> res = new ArrayList<>();

    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(combinationSum2(candidates, target));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        f(candidates, target, 0, new ArrayList<>());
        return res;
    }
    public static void f (int[] nums, int target, int start, List<Integer> list) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            f(nums, target - nums[i], i+1, list);
            list.remove(list.size() - 1);
            while (i+1 < nums.length && nums[i+1] == nums[i]) i++;
        }
    }
}
