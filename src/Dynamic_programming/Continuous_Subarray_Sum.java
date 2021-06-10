package Dynamic_programming;

import java.util.HashMap;
import java.util.Map;

// Given a list of non-negative numbers and a target integer k, write a function to check if the
// array has a continuous subarray of size at least 2 that sums up to a multiple of k, that is,
// sums up to n*k where n is also an integer.
// Input: [23, 2, 4, 6, 7],  k=6
// Output: True
// Explanation: Because [2, 4] is a continuous sub-array of size 2 and sums up to 6.

public class Continuous_Subarray_Sum {
    public static void main(String[] args) {
        int[] arr = {23, 2, 4, 6, 7};
        int k = 6;
        System.out.println(checkSubarraySum(arr, k));
    }
    public static boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length <= 1) return false;
        int sum = 0;
        Map<Integer, Integer> rem = new HashMap<>();
        rem.put(0,-1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int r = k == 0? sum: sum % k;
            if (rem.containsKey(r)){
                if (i - rem.get(r) >= 2) return true;
            }
            else rem.put(r, i);
        }
        return false;
    }
}
