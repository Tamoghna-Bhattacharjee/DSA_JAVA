package Arrays_algo.Boyer_Moore_Majority_Vote_algorithm;

import java.util.ArrayList;
import java.util.List;

public class Greater_than_Nby3 {
    public static void main(String[] args) {
        int[] nums = {1,1,1,3,3,2,2,2};
        System.out.println(majorityElement_Nby3(nums));
    }

    private static List<Integer> majorityElement_Nby3(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int a = nums.length / 3;
        // at most two element will be there
        int vote1 = 0, vote2 = 0, cand1 = Integer.MAX_VALUE, cand2 = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (cand1 == nums[i]) vote1++;
            else if (cand2 == nums[i]) vote2++;
            else if (vote1 == 0) {
                cand1 = nums[i];
                vote1 = 1;
            }else if (vote2 == 0) {
                cand2 = nums[i];
                vote2 = 1;
            }else {
                vote1--; vote2--;
            }
        }
        int count1 = 0, count2 = 0;
        for (int i: nums) {
            if (i == cand1) count1++;
            else if (i == cand2) count2++;
        }

        if (count1 > a) list.add(cand1);
        if (count2 > a) list.add(cand2);
        return list;
    }
}
