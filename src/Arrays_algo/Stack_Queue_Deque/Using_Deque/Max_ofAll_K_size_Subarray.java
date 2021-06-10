package Arrays_algo.Stack_Queue_Deque.Using_Deque;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

// https://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k/

public class Max_ofAll_K_size_Subarray {
    static int[] arr;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        findMax(3);
    }
    static void findMax(int k) {
        int n = arr.length;
        Deque<Integer> dq = new LinkedList<>();
        int i = 0;
        while (i < k) {
            if (!dq.isEmpty() && arr[i] >= arr[dq.peekLast()]) dq.pollLast();
            else dq.addLast(i++);
        }
        while (i < n) {
            System.out.println(arr[dq.peekFirst()]);
            while (!dq.isEmpty() && dq.peekFirst() <= i-k) dq.pollFirst();
            while (!dq.isEmpty() && arr[i] >= arr[dq.peekLast()]) dq.pollLast();
            dq.addLast(i++);
        }
        System.out.println(arr[dq.peekFirst()]);
    }
}
