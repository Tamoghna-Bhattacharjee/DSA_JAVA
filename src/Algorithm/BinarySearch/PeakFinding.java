package Algorithm.BinarySearch;

// https://www.geeksforgeeks.org/find-a-peak-in-a-given-array/

public class PeakFinding {
    public static void main(String[] args) {
        int[] arr = { 1, 20, 3, 4, 1, 0 };
        int n = arr.length;
        int L = 0, R = n-1;
        int ans = -1;
        while (L <= R) {
            int mid = (L + R)/ 2;
            int m = arr[mid];
            int leftNum = mid == 0? Integer.MIN_VALUE: arr[mid-1];
            int rgtNum = mid == n-1? Integer.MIN_VALUE: arr[mid+1];
            if (m >= leftNum && m >= rgtNum) {
                ans = m; break;
            }
            else if (leftNum > m) R = mid - 1;
            else L = mid + 1;
        }
        System.out.println(ans);
    }
}
