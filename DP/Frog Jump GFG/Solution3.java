// Bottom-Up Approach : Space Optimized
class Solution {
    int minCost(int[] height) {
        int n = height.length;
        // Edge Case
        if(n == 1){
            return 0;
        }


        int prev1 = Math.abs(height[1] - height[0]);
        int prev2 = 0;
        int curr = prev1;

        for(int i=2; i<n; i++){
            int jmpBack1 = Math.abs(height[i] - height[i-1]) + prev1;
            int jmpBack2 = Math.abs(height[i] - height[i-2]) + prev2;
            curr = Math.min(jmpBack1, jmpBack2);
            prev2 = prev1;
            prev1 = curr;
        }

        return curr;
    }
}