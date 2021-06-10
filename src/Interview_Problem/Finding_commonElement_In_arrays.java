package Interview_Problem;

import java.util.HashMap;
import java.util.Map;

public class Finding_commonElement_In_arrays {

    public static void main(String[] args) {

        /*
            Q> To find the common element b/w array

            Brute force solution
                    time complexity -> O(n^2) or O(n * m)
                    space complexity -> O(1)

            This solution
                    time complexity -> O(n) or O(n + m)
                    space complexity -> O(n)
        */


        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {10,11,12,13,5};

        Map<Integer, Boolean> tally = new HashMap<>();

        for(int i : arr1){
            tally.put(i, true);
        }

        for(int i: arr2){
            if(tally.get(i) != null)
                System.out.println(i);
        }

    }
}
