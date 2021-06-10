package Arrays_algo.Stack_Queue_Deque;

import java.util.Stack;

public class Maximum_Rectangle_Histogram {
    public static void main(String[] args) {
        int[] arr = {1};
        System.out.println(getMaxRect(arr));
    }
    public static int getMaxRect(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int i = 0, max_area = 0;
        while (i < height.length) {
            int h = height[i];
            if (stack.isEmpty() || h >= height[stack.peek()]) {
                stack.push(i);
                i++;
            }else {
                int top = height[stack.pop()];
                int l = stack.isEmpty()? i: i-1-stack.peek();
                max_area = Math.max(max_area, l*top);
            }
        }
        while (!stack.isEmpty()) {
            int top = height[stack.pop()];
            int l = stack.isEmpty()? i: i-1-stack.peek();
            max_area = Math.max(max_area, l*top);
        }
        return max_area;
    }
}
