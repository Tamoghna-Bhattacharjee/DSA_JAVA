package Arrays_algo;

public class Median_two_sorted_array {
    public static void main(String[] args) {
        int[] a = {1,2};
        int[] b = {3,4};
        System.out.println(findMedianSortedArrays(a, b));
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] X, Y;
        if (nums1.length <= nums2.length) {
            X = nums1; Y = nums2;
        }else{
            X = nums2; Y = nums1;
        }
        int x = X.length, y = Y.length;
        int start = 0, end = x;
        double ans = 0;
        while (true) {
            int part_x = (start + end) / 2;
            int part_y = (x + y + 1) /2 - part_x;
            int lx = part_x > 0? X[part_x - 1]: Integer.MIN_VALUE;
            int rx = part_x <= x - 1? X[part_x]: Integer.MAX_VALUE;
            int ly = part_y > 0? Y[part_y - 1]: Integer.MIN_VALUE;
            int ry = part_y <= y - 1? Y[part_y]: Integer.MAX_VALUE;
            int l_max = Math.max(lx, ly), r_min = Math.min(rx, ry);
            if (l_max <= r_min){
                ans = (x + y) % 2 == 0? (l_max + r_min) / 2.0: l_max;
                break;
            }
            else if (lx > ry){
                end = part_x - 1;
            }else {
                start = part_x+1;
            }
        }
        return ans;
    }
}
