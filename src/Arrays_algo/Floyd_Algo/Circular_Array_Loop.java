package Arrays_algo.Floyd_Algo;
// Google Question: find if a circular array has 1 and only 1 unique loop covering all index

//You are given a circular array nums of positive and negative integers. If a number k at an
// index is positive, then move forward k steps. Conversely, if it's negative (-k), move backward
// k steps. Since the array is circular, you may assume that the last element's next element
// is the first element, and the first element's previous element is the last element.

//Determine if there is a loop (or a cycle) in nums. A cycle must start and end at the same index
//and the cycle's length > 1. Furthermore, movements in a cycle must all follow a single direction.
// In other words, a cycle must not consist of both forward and backward movements.

//Example 1:
//Input: [2,-1,1,2,2]
//Output: true
//Explanation: There is a cycle, from index 0 -> 2 -> 3 -> 0. The cycle's length is 3.
//Example 2:
//Input: [-1,2]
//Output: false
//Explanation: The movement from index 1 -> 1 -> 1 ... is not a cycle, because the cycle's length
// is 1. By definition the cycle's length must be greater than 1.
//Example 3:
//Input: [-2,1,-1,-2,-2]
//Output: false
//Explanation: The movement from index 1 -> 2 -> 1 -> ... is not a cycle, because movement
// from index 1 -> 2 is a forward movement, but movement from index 2 -> 1 is a backward movement.
// All movements in a cycle must follow a single direction.

public class Circular_Array_Loop {
    public static void main(String[] args) {
        int[] nums = {2,-1,1,2,2};
        System.out.println(circularArrayLoop(nums));
    }
    public static boolean circularArrayLoop(int[] nums) {
        if (nums.length == 0) return false;
        if (nums.length == 1) return false;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) continue;
            int slow = i, fast = i;
            do {
                fast = getIndex(fast, nums);
                slow = getIndex(slow, nums);
                if ((nums[slow] > 0 && nums[fast] < 0) || (nums[slow] < 0 && nums[fast] > 0)) break;
                fast = getIndex(fast, nums);
                if ((nums[slow] > 0 && nums[fast] < 0) || (nums[slow] < 0 && nums[fast] > 0)) break;

            } while (slow != fast);
            if (slow == fast) {
                if (slow == getIndex(slow, nums)) continue;
                return true;
            }
            int tempSlow = slow;
            do {
                nums[slow] = 0;
                slow = getIndex(slow, nums);
            }while (slow != tempSlow);
        }
        return false;
    }
    public static int getIndex(int i, int[] nums) {
        int n = nums.length;
        return i + nums[i] >= 0? (i + nums[i]) % n: n + (i + nums[i]) % n;
    }
}
