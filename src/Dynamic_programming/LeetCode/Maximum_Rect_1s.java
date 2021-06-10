package Dynamic_programming.LeetCode;

import java.util.Arrays;
import java.util.Stack;

public class Maximum_Rect_1s {
    public static void main(String[] args) {
        char[][] ch = {
                {'0','1'},
                {'1','0'}};
        System.out.println(maxRectOnes(ch));
    }
    private static int maxRectOnes(char[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        int max_area = 0;
        int[] dp = new int[col];
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (matrix[i][j] != '0')
                    dp[j] += matrix[i][j] - 48;
                else
                    dp[j] = 0;
            }
            System.out.println(Arrays.toString(dp));
            int area = getHistMaxRect(dp);
            max_area = Math.max(max_area, area);
        }
        return max_area;
    }
    private static int getHistMaxRect(int[] arr){
        Stack<Integer> stack = new Stack<>();
        int i = 0, max_area = 0;
        while (i < arr.length){
            if (stack.isEmpty() || arr[stack.peek()] <= arr[i]){
                stack.push(i); i++;
            }else{
                int top = stack.pop();
                int area = arr[top] * (stack.isEmpty()? i: i - 1 - stack.peek());
                max_area = Math.max(max_area, area);
            }
        }
        while (!stack.isEmpty()){
            int top = stack.pop();
            int area = arr[top] * (stack.isEmpty()? i: i - 1 - stack.peek());
            max_area = Math.max(max_area, area);
        }
        return max_area;
    }
}
