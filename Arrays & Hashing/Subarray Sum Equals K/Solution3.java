// Longest subarray with sum K
/*
Given an array nums of size n and an integer k, find the length of the longest sub-array that sums to k. If no such sub-array exists, return 0.
Input: nums = [10, 5, 2, 7, 1, 9],  k=15
Output: 4
Explanation: The longest sub-array with a sum equal to 15 is [5, 2, 7, 1], which has a length of 4. This sub-array starts at index 1 and ends at index 4, and the sum of its elements (5 + 2 + 7 + 1) equals 15. Therefore, the length of this sub-array is 4. 
*/

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int longestSubarray(int[] nums, int k) {
        Map<Integer, Integer> prefixMap = new HashMap<>();
        int prefixSum = 0;
        int maxLen = 0;
        for(int i = 0; i<nums.length; i++){
            prefixSum += nums[i];
            if(prefixSum == k){
                maxLen = Math.max(maxLen, i+1);
            } else if(prefixMap.containsKey(prefixSum - k)){
                maxLen = Math.max(maxLen, i - prefixMap.get(prefixSum - k));
            }
            prefixMap.putIfAbsent(prefixSum, i);
        }

        return maxLen;
    }
}