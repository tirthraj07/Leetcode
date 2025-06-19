class Solution {
    public int maxSubArray(int[] nums) {
    
        int idx = 0;
        int max = nums[0];
        for(; idx < nums.length; idx++){
            if(nums[idx] >= 0){
                break;
            }
            else if(nums[idx] > max){
                max = nums[idx];
            }
        }

        if(idx == nums.length){
            return max;
        }
        
        int currentSum = 0;
        int maxSum = nums[idx];
        int i = idx;
        int j = idx;
        while(true){
            if(j >= nums.length){
                break;
            }
            if(currentSum >= 0){
                currentSum += nums[j];
                j++;
            }
            else{
                currentSum -= nums[i];
                i++;
            }
            maxSum = Math.max(currentSum, maxSum);
            while(i == j && i < nums.length && nums[i] < 0){
                i++;
                j++;
            }
        }
        
        return maxSum;
    }
}