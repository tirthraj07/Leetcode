import java.util.*;

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int prefixSum = 0;
        int totalCount = 0;
        for(int i = 0; i < nums.length; i++){
            prefixSum += nums[i];
            int r = prefixSum % k;
            // nums[i] can be negative => prefixSum can be negative => r can be negative
            // Edge case
            if(r < 0) r += k;

            int count = map.getOrDefault(r, 0);
            totalCount += count;

            map.put(r, count + 1);
        }

        return totalCount;
    }
}