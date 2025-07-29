import java.util.HashMap;
import java.util.Map;

class Solution {
    public int subarraySum(int[] nums, int k) {
        // We will store prefixSum, occurences of prefix sum
        // If we want to get all the subarrays, the we would have stored the list of indices at which we found the prefix sum
        // If we want to find the longest subarray, then we would only store the index of the first occurrence of the prefix sum

        Map<Integer, Integer> prefixMap = new HashMap<>();
        // Need to handle subarrays that start at index 0
        prefixMap.put(0, 1); 
        int prefixSum = 0;
        int count = 0;
        for(int i=0; i<nums.length; i++){
            prefixSum += nums[i];
            count += prefixMap.getOrDefault(prefixSum - k, 0);
            prefixMap.put(prefixSum, prefixMap.getOrDefault(prefixSum, 0)+1);
        }

        return count;
    }
}