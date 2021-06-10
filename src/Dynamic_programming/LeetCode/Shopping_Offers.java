package Dynamic_programming.LeetCode;

import java.util.*;

public class Shopping_Offers {
    private static int[] p;
    private static List<List<Integer>> offers;
    static Map<String, Integer> map;
    public static void main(String[] args) {
        List<Integer> price = new ArrayList<>(Arrays.asList(2,3,4));
        List<List<Integer>> special = new ArrayList<>();
        special.add(Arrays.asList(1,1,0,4));
        special.add(Arrays.asList(2,2,1,9));
        List<Integer> needs = new ArrayList<>(Arrays.asList(1,2,1));
        System.out.println(shoppingOffers(price, special, needs));
    }
    public static int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        if (needs.size() == 0 || price.size() == 0) return 0;

        map = new HashMap<>();
        p = new int[price.size()];
        offers = special;
        int[] n = new int[needs.size()];
        for (int i = 0; i < needs.size(); i++) {
            n[i] = needs.get(i);
            p[i] = price.get(i);
        }
        if (special.size() == 0) return multiply(p,n);
        return f(n);
    }

    public static int f(int[] needs) {
        String key = Arrays.toString(needs);
        if (map.containsKey(key))
            return map.get(key);
        int min = Integer.MAX_VALUE;
        boolean isContinue = false;
        for (List<Integer> o: offers) {
            int[] arr = needs.clone();
            for (int i = 0; i < o.size() - 1; i++) {
                if (o.get(i) > needs[i]) {
                    isContinue = true;
                    break;
                }
                arr[i] -= o.get(i);
            }
            if (isContinue){
                isContinue = false;
                continue;
            }
            min = Math.min(min, o.get(o.size() - 1) + f(arr));
        }
        int a = Math.min(min, multiply(p, needs));
        map.put(key, a);
        return a;
    }
    public static int multiply(int[] a, int[] b) {
        int s = 0;
        for (int i = 0; i < a.length; i++) {
            s += a[i] * b[i];
        }
        return s;
    }
}
