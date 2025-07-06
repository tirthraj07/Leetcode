import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for(int num: nums){
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        List<Integer> sol = new ArrayList<>();

        for(Map.Entry<Integer, Integer> entry : freq.entrySet()){
            if(entry.getValue() > (nums.length / 3)){
                sol.add(entry.getKey());
            }
        }
        return sol;
    }
}