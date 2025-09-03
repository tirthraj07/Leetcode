/*
Given an integer array height[] where height[i] represents the height of the i-th stair, 
a frog starts from the first stair and wants to reach the top. 
From any stair i, the frog has two options: it can either jump to the (i+1)th stair or the (i+2)th stair. 
The cost of a jump is the absolute difference in height between the two stairs. 
Determine the minimum total cost required for the frog to reach the top.

Link: https://www.geeksforgeeks.org/problems/geek-jump/1
*/


// Top-Down Approach : Memoization
import java.util.Arrays;

class Solution {
    int minCost(int[] height) {
        int n = height.length;
        if(n == 1){
            return 0;
        }
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = Math.abs(height[1] - height[0]);
        return solve(n-1, dp, height);
    }

    int solve(int i, int[] dp, int[] height){
        if(i == 0 || i == 1){
            return dp[i];
        }
        if(dp[i] == -1){
            int jmpBack1 = Math.abs(height[i] - height[i-1]) + solve(i-1, dp, height);
            int jmpBack2 = Math.abs(height[i] - height[i-2]) + solve(i-2, dp, height);
            dp[i] = Math.min(jmpBack1, jmpBack2);
        }
        return dp[i];
    }

}