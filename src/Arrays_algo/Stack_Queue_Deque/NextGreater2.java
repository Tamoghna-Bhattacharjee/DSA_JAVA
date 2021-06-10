package Arrays_algo.Stack_Queue_Deque;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

// next greater for circular array
// given a circular array and you need to find the next greater element for every element

public class NextGreater2 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = scan.nextInt();
        System.out.println(Arrays.toString(nextGreaterElements(arr)));
    }
    static int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] arr = new int[2*n];
        for (int i = 0; i < 2*n; i++) {
            if (i < n) arr[i] = nums[i];
            else arr[i] = nums[i-n];
        }
        int[] G = new int[2*n];
        Arrays.fill(G, -1);
        int j = 0;
        Stack<Integer> stack = new Stack<>();
        while (j < 2*n) {
            if (!stack.isEmpty() && arr[j] > arr[stack.peek()])
                G[stack.pop()] = arr[j];
            else stack.push(j++);
        }
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            if (G[i] != -1) res[i] = G[i];
            else res[i] = G[n+i];
        }
        return res;
    }
}
