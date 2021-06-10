package Arrays_algo.Boyer_Moore_Majority_Vote_algorithm;

public class Greater_than_Nby2 {
    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(majorityElement_Nby2(nums));
    }
    public static int majorityElement_Nby2 (int[] nums) {
        int candidate = 0, vote = 0;
        for (int i: nums) {
            if (vote == 0) {
                candidate = i;
                vote = 1;
            }else if (candidate == i) vote++;
            else vote--;
        }
        int count = 0;
        for (int i: nums) {
            if (i == candidate) count++;
        }
        return candidate;
    }
}
