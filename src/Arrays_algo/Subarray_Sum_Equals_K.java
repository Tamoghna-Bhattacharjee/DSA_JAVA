package Arrays_algo;

import java.util.HashMap;
import java.util.Map;

public class Subarray_Sum_Equals_K {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1,2,3};
        int k = 2;
        System.out.println(subarraySum(nums, k));
    }
    public static int subarraySum(int[] nums, int k) {
        int res = 0;
        int sum = 0;
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (preSum.containsKey(sum - k)) // sum(i, j) = sum (0, j) - sum(0, i-1) = k;
                res += preSum.get(sum - k);
            preSum.put(sum, preSum.getOrDefault(sum, 0)+1);
        }
        
        return res;
    }
}
