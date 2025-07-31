// Time Limit Exceeded
// This can be used to find the minimum steps to reach final index - where we want to find which steps we jumped from
class Solution {
    public boolean canJump(int[] nums) {
        return canJump(nums.length - 1, nums);
    }

    private boolean canJump(int currIdx, int[] nums){
        if(currIdx == 0){
            return true;
        }

        for(int i=0; i<currIdx; i++){
            if(currIdx - i <= nums[i] && canJump(i, nums)){
                return true;
            }
        }

        return false;
    }
    
}