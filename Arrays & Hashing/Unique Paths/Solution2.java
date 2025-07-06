import java.util.HashMap;
import java.util.Map;

// This won't get a TLE but this approach is slow

class Solution {
    Map<String, Integer> sol = new HashMap<>();

    private int backtrack(int i, int j, int m, int n){
        if(i >= m || j >= n){
            return 0;
        }

        if(i == m-1 && j == n-1){
            return 1;
        }
        
        String key = i + "," + j;
    
        if(!sol.containsKey(key)){
            int ans = backtrack(i+1, j, m, n) + backtrack(i, j+1, m, n);
            sol.put(key, ans);
        }

        return sol.get(key);
    }


    public int uniquePaths(int m, int n) {
        return backtrack(0,0,m,n);
    }
}