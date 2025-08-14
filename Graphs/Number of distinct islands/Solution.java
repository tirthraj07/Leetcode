import java.util.*;

/*
https://takeuforward.org/plus/dsa/problems/number-of-distinct-islands

Given a boolean 2D matrix grid of size N x M. Find the number of distinct islands where a group of connected 1s (horizontally or vertically) forms an island. Two islands are considered to be same if and only if one island is equal to another (not rotated or reflected).
Input: grid = [[1, 1, 0, 0, 0], [1, 1, 0, 0, 0], [0, 0, 0, 1, 1],[0, 0, 0, 1, 1]]

Output: 1

Input: grid = [[1, 1, 0, 1, 1], [1, 0, 0, 0, 0], [0, 0, 0, 0, 1],[1, 1, 0, 1, 1]]

Output: 3
*/

class Solution {
    private int[] di = {0,0,-1,1};
    private int[] dj = {1,-1,0,0};

    public int countDistinctIslands(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Set<List<Integer>> set = new HashSet<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]==1 && !visited[i][j]){
                    List<Integer> path = new ArrayList<>();
                    dfs(i,j, grid, visited, path, i,j);
                    set.add(path);
                }
            }
        }
        return set.size();
    }

    private void dfs(int i, int j, int[][] grid, boolean[][] visited, List<Integer> path, int base_i, int base_j){
        int m = grid.length;
        int n = grid[0].length;
        visited[i][j] = true;
        path.add(i-base_i);
        path.add(j-base_j);
        for(int k=0; k<4; k++){
            int incr_i = i + di[k];
            int incr_j = j + dj[k];

            if(incr_i >= 0 && incr_j >= 0 && incr_i < m && incr_j < n && grid[incr_i][incr_j] == 1 && !visited[incr_i][incr_j]){
                dfs(incr_i, incr_j, grid, visited, path, base_i, base_j);
            }
        }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        int[][] grid = {{1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 1, 1},{0, 0, 0, 1, 1}};
        System.out.println(sol.countDistinctIslands(grid));
    }

}
