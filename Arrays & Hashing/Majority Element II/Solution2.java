import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Set<Integer> sol = new HashSet<>(); 
        Map<Integer, Integer> freq = new HashMap<>();
        int nBy3 = nums.length / 3;
        for(int num: nums){
            int occurrence = freq.getOrDefault(num, 0);
            occurrence++;
            freq.put(num, occurrence);
            if(occurrence > nBy3){
                sol.add(num);
            }
            if(sol.size() == 2){
                break;
            }
        }

        
        return sol.stream().toList();
    }
}