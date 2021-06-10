package Arrays_algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Three_Sum {
    public static void main(String[] args) {
        int[] arr = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(arr));
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        List<List<Integer>> arr = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            int sum = -nums[i];
            while (right > left) {
                int a = nums[right] + nums[left];
                if (a == sum) {
                    ArrayList<Integer> temp = new ArrayList<>(Arrays.asList(nums[i], nums[left], nums[right]));
                    arr.add(temp);
                    while (right > left && nums[right] == temp.get(2)) right--;
                    while (right > left && nums[left] == temp.get(1)) left++;
                }else if (a > sum)
                    right--;
                else
                    left++;
            }
            while (i + 1 < nums.length && nums[i + 1] == nums[i])
                i++;
        }
        return arr;
    }
}
