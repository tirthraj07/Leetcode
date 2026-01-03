import java.util.*;

class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        long totalSum = 0;
        
        // Calculate Total Sum and the 'Target Remainder' we need to remove
        for (int num : nums) {
            totalSum = (totalSum + num) % p;
        }
        
        int target = (int) totalSum;
        
        // Edge Case: The array is already divisible by p
        if (target == 0) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); 
        
        long currentSum = 0;
        int minWindow = n;

        for (int i = 0; i < n; i++) {
            currentSum = (currentSum + nums[i]) % p;
            int currentRem = (int) currentSum;
            
            // Note: +p is to handle negative results from subtraction
            int needed = (currentRem - target + p) % p;

            if (map.containsKey(needed)) {
                int prevIndex = map.get(needed);
                minWindow = Math.min(minWindow, i - prevIndex);
            }

            // Always store the most recent index of this remainder
            map.put(currentRem, i);
        }

        return minWindow == n ? -1 : minWindow;
    }
}