package Dynamic_programming.LeetCode;
import java.util.*;

public class FrogJump {
    public static void main(String[] args) {
        int[] stones = {0, 1, 3, 5, 6, 8, 12, 17};
        //doesServive_unoptimised(stones);
        System.out.println(doesServive_optimised(stones));

    }

    public static void doesServive_unoptimised(int[] stones){
        if (stones[1] != 1)
            System.out.println(false);

        LinkedHashMap<Integer, ArrayList<Integer>> dp = new LinkedHashMap<>();

        for (int i = 1; i < stones.length; i++){
            dp.put(stones[i], new ArrayList<>());
        }
        dp.get(stones[1]).add(1);

        for (Map.Entry<Integer, ArrayList<Integer>> stone: dp.entrySet()){
            for (int i: stone.getValue()){
                if(dp.keySet().contains(stone.getKey() + i)){
                    dp.get(stone.getKey() + i).add(i);
                }
                if(dp.keySet().contains(stone.getKey() + i + 1)){
                    dp.get(stone.getKey() + i + 1).add(i + 1);
                }
                if (i - 1 > 0){
                    if(dp.keySet().contains(stone.getKey() + i - 1)){
                        dp.get(stone.getKey() + i - 1).add(i - 1);
                    }
                }

            }
        }

        System.out.println(dp);

        if (dp.get(stones[stones.length - 1]).size() > 0)
            System.out.println(true);
    }

    public static boolean doesServive_optimised(int[] stones){

        for (int i = 3; i < stones.length; i++){
            if (stones[i] > stones[i - 1] * 2)
                return false;
        }

        Set<Integer> stone_position = new HashSet<>();
        for(int i: stones){
            stone_position.add(i);
        }
        int final_stone = stones[stones.length - 1];
        Stack<Integer> pos = new Stack<>();
        Stack<Integer> jump = new Stack<>();

        pos.push(0);
        jump.push(0);

        while (!pos.isEmpty()){

            int current_pos = pos.pop();
            int current_jump = jump.pop();

            for (int i = current_jump - 1; i <= current_jump + 1; i++) {
                if (i <= 0)
                    continue;
                int next_pos = current_pos + i;
                if (next_pos == final_stone)
                    return true;
                if (stone_position.contains(next_pos)) {
                    pos.push(next_pos);
                    jump.push(i);
                }
            }
        }
        return false;
    }

}
