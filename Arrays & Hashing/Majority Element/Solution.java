import java.util.HashMap;
import java.util.Map;

class Solution {
    public int majorityElement(int[] nums) {
        // O(N) Time and O(N) space
        Map<Integer, Integer> freq =  new HashMap<>();
        for(int num: nums){
            freq.putIfAbsent(num, 0);
            freq.put(num, freq.get(num) + 1);
        }
        for(Map.Entry<Integer, Integer> entry : freq.entrySet()){
            if(entry.getValue() > (nums.length / 2)){
                return entry.getKey();
            }
        }
        return 0;
    }
}