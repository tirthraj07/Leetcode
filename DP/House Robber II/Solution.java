class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        } else if(n == 2){
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(solve(nums, 0, n-2), solve(nums, 1, n-1));
    }

    public int solve(int[] nums, int start, int end){
        int n = end - start + 1;
        int[] dp = new int[n];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);
        for(int i=2; i<n; i++){
            dp[i] = Math.max(nums[start+i] + dp[i-2], dp[i-1]);
        }
        return dp[n-1];
    }

}