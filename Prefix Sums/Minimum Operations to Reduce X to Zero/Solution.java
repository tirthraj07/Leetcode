class Solution {
    public int minOperations(int[] nums, int x) {
        int sum = 0;
        for(int num: nums) sum += num;
        int target = sum - x;
        // Edge cases
        if(target == 0) return nums.length;
        else if(target < 0) return -1;

        int i = 0;
        int currentSum = 0;
        int maxWindow = -1;

        for(int j=0; j<nums.length; j++){
            currentSum += nums[j];

            while(i<j&&currentSum>target){
                currentSum -= nums[i];
                i+=1;
            }

            if(currentSum == target){
                maxWindow = Math.max(maxWindow, j-i+1);
            }
        
        }

        return maxWindow == -1 ? -1 : nums.length - maxWindow;
    }
}