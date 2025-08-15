import java.util.*;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])){
                int prevIdx = map.get(nums[i]);
                if(i - prevIdx <= k){
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;        
    }
}