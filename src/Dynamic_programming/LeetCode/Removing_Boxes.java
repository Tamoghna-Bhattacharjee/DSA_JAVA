package Dynamic_programming.LeetCode;

public class Removing_Boxes {
    static int[][][] dp;
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 2, 2, 3, 4, 3, 1};
        System.out.println(removeBoxes(arr));
    }
    private static int removeBoxes(int[] boxes) {
        dp = new int[boxes.length][boxes.length][boxes.length];
        return util(boxes, 0, boxes.length - 1, 0);
    }
    private static int util(int[] boxes, int i, int j, int k) {
        if (i > j) return 0;
        if (dp[i][j][k] != 0) return dp[i][j][k];
        int count = 0, v = i;
        while (v <= j && boxes[i] == boxes[v]){
            count++;
            v++;
        }
        int res = util(boxes, i+count, j, 0) + (k+count)*(k+count);
        for (v = i+count; v <= j; v++){
            if (boxes[v] == boxes[i])
                res = Math.max(res, util(boxes, i+count, v-1, 0) +
                                        util(boxes, v, j, k+count));
        }
        return dp[i][j][k] = res;
    }
}
