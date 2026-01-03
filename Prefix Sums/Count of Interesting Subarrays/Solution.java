import java.util.*;

class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        long count = 0;

        long currIntrestingElements = 0;
        
        //  Remainder : Count
        Map<Integer, Long> map = new HashMap<>();

        map.put(0, 1L);

        for(int i=0; i<nums.size(); i++){
            int num = nums.get(i);

            if(num % modulo == k) currIntrestingElements++;

            int needed = (int) (currIntrestingElements - k) % modulo;
            if(needed < 0) needed += modulo;

            count += map.getOrDefault(needed, 0L);
            
            int rem = (int) currIntrestingElements % modulo;

            map.put(rem, map.getOrDefault(rem, 0L) + 1);
        }

        return count;
    }
}