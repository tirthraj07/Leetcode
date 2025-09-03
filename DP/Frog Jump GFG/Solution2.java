// Bottom-Up Approach : Tabulation
class Solution {
    int minCost(int[] height) {
        int n = height.length;
        // Edge Case
        if(n == 1){
            return 0;
        }

        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = Math.abs(height[1] - height[0]);

        for(int i=2; i<n; i++){
            int jmpBack1 = Math.abs(height[i] - height[i-1]) + dp[i-1];
            int jmpBack2 = Math.abs(height[i] - height[i-2]) + dp[i-2];
            dp[i] = Math.min(jmpBack1, jmpBack2);
        }

        return dp[n-1];
    }
}