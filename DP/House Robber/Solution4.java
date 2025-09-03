// Top Down Approach: Memoization

import java.util.Arrays;

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        dp[0] = nums[0];
        dp[1] = Math.max(nums[1], nums[0]);
        return solve(n-1, dp, nums);
    }
    
    public int solve(int i, int[] dp, int[] nums){
        if(i == 0 || i == 1){
            return dp[i];
        }
        if(dp[i] == -1){
            dp[i] = Math.max(nums[i] + solve(i-2, dp, nums), solve(i-1, dp, nums));
        }
        return dp[i];
    }

}