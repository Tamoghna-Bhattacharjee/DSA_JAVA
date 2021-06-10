package Arrays_algo.Floyd_Algo;

//Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive),
// prove that at least one duplicate number must exist. Assume that there is only one duplicate
// number, find the duplicate one.
//Example 1:
//Input: [1,3,4,2,2]
//Output: 2
//Example 2:
//Input: [3,1,3,4,2]
//Output: 3

import java.util.HashSet;
import java.util.Set;

public class Duplicate_Number {
    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};
        System.out.println(findDuplicate_floyd_algo(nums));
        System.out.println(findDuplicate_using_Set(nums));
    }
    public static int findDuplicate_floyd_algo(int[] nums) {
        // floyd's algorithm
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
    public static int findDuplicate_using_Set(int[] nums) {
        Set<Integer> s = new HashSet<>();
        for (int i: nums) {
            if (s.contains(i)) return i;
            s.add(i);
        }
        return -1;
    }
    //for example: index = [0 1 2 3 4 5 6 7]; nums=[5 2 1 3 5 7 6 4].
    // (slow)nums[slow] = (0)5 (5)7 (7)4 (4)5; fast = (0)5 (7)4 (5)7 (4)5; ---->
    // when they meets at (idx=4)(value=5), you know you have a cycle.
    //
    //Take a look at the cycle by the indices and values:
    //
    //idx: 0--->5--->7--->4-->(goes back to idx=5)
    //
    //val: 5--->7--->4--->5-->(goes back to val=7)
}
