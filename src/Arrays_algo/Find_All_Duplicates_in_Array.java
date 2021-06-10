package Arrays_algo;

import java.util.ArrayList;
import java.util.List;

//Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice
// and others appear once.Find all the elements that appear twice in this array.
//Could you do it without extra space and in O(n) runtime?
//Example:
//Input:
//[4,3,2,7,8,2,3,1]
//Output:
//[2,3]

public class Find_All_Duplicates_in_Array {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(findDuplicates(nums));
    }
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> arr = new ArrayList<>();
        for (int i: nums) {
            int index = Math.abs(i) - 1;
            if (nums[index] < 0) arr.add(index+1);
            nums[index] = -nums[index];
        }
        return arr;
    }
}
