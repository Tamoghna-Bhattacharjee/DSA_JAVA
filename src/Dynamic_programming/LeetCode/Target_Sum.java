package Dynamic_programming.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Target_Sum {

    public static void main(String[] args) {
        int[] nums = {1,0,0,0};
        int S = 1;
        System.out.println(findTargetSumWays(nums, S));
    }

    public static int findTargetSumWays(int[] nums, int S){
        int sum = 0;
        for (int i : nums)
            sum += i;
        if (S > sum) return 0;

        String[] key = new String[nums.length];
        int[] limits = new int[nums.length];
        HashMap<String, ArrayList<Integer>> dp = new HashMap<>();
        for (int i = 0; i < nums.length; i++){
            key[i] = nums[i] + "-" + i;
            limits[i] = sum;
            sum -= nums[i];
            dp.put(key[i], new ArrayList<>());
        }
        System.out.println(Arrays.toString(key) + "\n" + Arrays.toString(limits));

        if (S + nums[0] <= limits[0]) dp.get(key[0]).add(S + nums[0]);
        if (S - nums[0] >= -limits[0]) dp.get(key[0]).add(S - nums[0]);

        for (int i = 1; i < nums.length; i++){
            ArrayList<Integer> prev = new ArrayList<>(dp.get(key[i - 1]));
            for (int n : prev){
                if (n + nums[i] <= limits[i]) dp.get(key[i]).add(n + nums[i]);
                if (n - nums[i] >= -limits[i]) dp.get(key[i]).add(n - nums[i]);
            }
        }

        int ways = 0;
        for (int i : dp.get(key[key.length - 1])){
            if (i == 0)
                ways++;
        }

        return ways;
    }
}
