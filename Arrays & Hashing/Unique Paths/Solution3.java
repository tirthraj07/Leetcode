import java.util.Arrays;

class Solution {
    private int[][] dp;
    
    private int backtrack(int i, int j, int m, int n){
        if(i >= m || j >= n){
            return 0;
        }
        else if(i == m-1 && j == n-1){
            return 1;
        }

        if(dp[i][j] == -1){
            dp[i][j] = backtrack(i+1, j, m, n) + backtrack(i, j+1, m, n);
        }

        return dp[i][j];
        
    }

    public int uniquePaths(int m, int n) {
        dp = new int[m][n];
        for(int[] arr : dp){
            Arrays.fill(arr, -1);
        }
        return backtrack(0,0,m,n);
    }
}