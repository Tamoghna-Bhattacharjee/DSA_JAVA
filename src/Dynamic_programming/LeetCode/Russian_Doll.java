package Dynamic_programming.LeetCode;

import java.util.Arrays;
import java.util.Comparator;

//You have a number of envelopes with widths and heights given as a pair of integers (w, h).
// One envelope can fit into another if and only if both the width and height of one envelope
// is greater than the width and height of the other envelope.

//        What is the maximum number of envelopes can you Russian doll? (put one inside other)
//        Note:
//        Rotation is not allowed.
//        Example:
//        Input: [[5,4],[6,4],[6,7],[2,3]]
//        Output: 3
//        Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).

public class Russian_Doll {
    public static void main(String[] args) {
        int[][] env = {{6,4},{5,4}, {6,7}, {2,3}};
        System.out.println(maxEnvelop(env));
    }
    private static int maxEnvelop(int[][] envelopes) {
        if (envelopes.length == 0) return 0;
        if (envelopes.length == 1) return 1;
        Comparator<int[]> comp = new Comparator<int[]>() {
            @Override
            public int compare(int[] e1, int[] e2){
                return e1[0] - e2[0];
            }
        };
        Arrays.sort(envelopes, comp);
        for (int i = 0; i < envelopes.length; i++) System.out.print(Arrays.toString(envelopes[i]));
        System.out.println();

        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);
        int max = 1;

        for (int i = 1; i < envelopes.length; i++){
            int[] curr = envelopes[i];
            for (int j = i-1; j >= 0; j--){
                int[] prev = envelopes[j];
                if (curr[0] > prev[0] && curr[1] > prev[1]){
                    dp[i] =Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max, dp[i]);
                }
            }
        }

        return max;
    }
}
