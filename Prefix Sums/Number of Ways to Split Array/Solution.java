class Solution {
    public int waysToSplitArray(int[] nums) {
        long sum = 0;
        for(int num: nums) sum += num;
        int count = 0;
        long prefixSum = 0;
        for(int i = 0; i<nums.length - 1; i++){
            prefixSum += nums[i];
            sum -= nums[i];
            if(prefixSum >= sum) count += 1;
        }

        return count;
    }
}