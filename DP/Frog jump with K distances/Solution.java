/*
Frog Jump with K Distances
A frog wants to climb a staircase with n steps. Given an integer array heights, where heights[i] contains the height of the ith step, and an integer k.
To jump from the ith step to the jth step, the frog requires abs(heights[i] - heights[j]) energy, where abs() denotes the absolute difference. 
The frog can jump from the ith step to any step in the range [i + 1, i + k], provided it exists. Return the minimum amount of energy required by the frog to go from the 0th step to the (n-1)th step.
*/

class Solution {
    public int frogJump(int[] heights, int k) {
        int n = heights.length;
        if(n == 1){
            return 0;
        }
        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = Math.abs(heights[1] - heights[0]);
        
        for(int i=2; i<n; i++){
            dp[i] = Integer.MAX_VALUE;
            for(int itr=1; itr<=k && i-itr >= 0; itr++){
                dp[i] = Math.min(dp[i], dp[i-itr] + Math.abs(heights[i] - heights[i-itr]));
            }
        }
        
        return dp[n-1];
    }       
}