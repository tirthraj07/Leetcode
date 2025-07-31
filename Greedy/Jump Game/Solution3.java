class Solution {
    public boolean canJump(int[] nums) {
        int maxJumpIdx = 0;
        for(int i=0; i<nums.length; i++){
            if(maxJumpIdx >= nums.length - 1){
                return true;
            } else if(maxJumpIdx < i){
                return false;
            }
            maxJumpIdx = Math.max(maxJumpIdx, i + nums[i]);
        }

        return false;
    }
    
}