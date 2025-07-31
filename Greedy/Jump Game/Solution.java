// Time Limit Exceeded
class Solution {
    public boolean canJump(int[] nums) {
        return canJump(0, nums);
    }

    private boolean canJump(int currIdx, int[] nums){
        if(currIdx >= nums.length){
            return false;
        } else if(currIdx == nums.length - 1){
            return true;
        }

        for(int incr = nums[currIdx]; incr > 0; incr--){
            if(canJump(currIdx + incr, nums)){
                return true;
            }
        }

        return false;
    }
}