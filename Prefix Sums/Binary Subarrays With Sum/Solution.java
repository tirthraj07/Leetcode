class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        int[] map = new int[n+1];
        map[0] = 1;
        int prefixSum = 0;
        int count = 0;
        
        for(int i = 0; i<n; i++){
            prefixSum += nums[i];
            int diff = prefixSum - goal;
            if(diff >= 0){
                count += map[diff];
            }
            map[prefixSum] += 1;
        }

        return count;
    }
}