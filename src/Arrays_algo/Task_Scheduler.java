package Arrays_algo;

import java.util.*;
// Given a char array representing tasks CPU need to do. It contains capital letters A to Z
// where different letters represent different tasks. Tasks could be done without original
// order. Each task could be done in one interval. For each interval, CPU could finish one
// task or just be idle.However, there is a non-negative cooling interval n that means between
// two same tasks, there must be at least n intervals that CPU are doing different tasks or just
// be idle.You need to return the least number of intervals the CPU will take to finish all the
// given tasks.
//Example:
//
//Input: tasks = ["A","A","A","B","B","B"], n = 2
//Output: 8
//Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
public class Task_Scheduler {
    public static void main(String[] args) {
        char[] tasks = {'A','A','A','B','B','B'};
        int n = 2;
        System.out.println(leastInterval_general_solution(tasks, n));
        System.out.println(leastInterval_best_solution(tasks, n));
    }
    public static int leastInterval_general_solution(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch: tasks) map.put(ch, map.getOrDefault(ch, 0) + 1);
        Comparator<Map.Entry<Character, Integer>> cmp = new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        };
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>(cmp);
        pq.addAll(map.entrySet());
        int time = 0;
        while (true) {
            int interval = n + 1;
            List<Map.Entry<Character, Integer>> list = new ArrayList<>();
            while (interval > 0 && !pq.isEmpty()) {
                Map.Entry<Character, Integer> i = pq.poll();
                i.setValue(i.getValue() - 1);
                list.add(i);
                interval--;
                time++;
            }
            for (Map.Entry<Character,Integer> l: list) {
                if (l.getValue() > 0) pq.add(l);
            }
            if (pq.isEmpty()) break;
            time += interval;
        }
        return time;
    }
    public static int leastInterval_best_solution(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (char t: tasks) {
            map.put(t, map.getOrDefault(t, 0) + 1);
            max = Math.max(max, map.get(t));
        }
        int max_freq = 0;
        for (char ch: map.keySet()) {
            if (max == map.get(ch)) max_freq++;
        }
        int inter_space = max - 1;
        int inter_length = n - (max_freq - 1);
        int empty_spot = inter_space * inter_length;
        int available_spot = tasks.length - max * max_freq;
        int idle = Math.max(0, empty_spot - available_spot);
        return tasks.length + idle;
    }
}
