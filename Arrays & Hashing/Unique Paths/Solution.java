// This solution gets TLE

class Solution {
    private int backtrack(int i, int j, int m, int n){
        if(i >= m || j >= n){
            return 0;
        }
        if(i == m-1 && j == n-1){
            return 1;
        }
        return backtrack(i, j+1, m, n) + backtrack(i+1, j, m, n);
    }

    public int uniquePaths(int m, int n) {
        return backtrack(0,0,m,n);
    }
}