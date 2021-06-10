package Constructive_algo;

import java.util.*;
// https://www.codechef.com/problems/RECNDROT
public class Chef_and_Rotation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            int n = scan.nextInt();
            int[] arr = new int[n];
            Map<Integer, ArrayList<Integer>> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                arr[i] = scan.nextInt();
                if (!map.containsKey(arr[i])) {
                    map.put(arr[i], new ArrayList<>());
                }
                map.get(arr[i]).add(i);
            }
            Arrays.sort(arr);
            int cnt = 1, l = map.get(arr[0]).get(0);
            for (int i = 1; i < n; i++) {
                if (arr[i] == arr[i-1]) continue;
                int idx = Collections.binarySearch(map.get(arr[i]), l);
                if (-idx-1 == map.get(arr[i]).size()) {
                    cnt++; l = map.get(arr[i]).get(0);
                }else {
                    l = map.get(arr[i]).get(-idx-1); // lower bound
                }
            }
            System.out.println(cnt);
        }
    }
}
