@SuppressWarnings("all")
class Solution {
    private int maxArea = 0;
    private int currentArea = 0;
    private int[][] grid;
    private boolean[][] visitedGrid;
    private int m;
    private int n;

    private void traverse(int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n)
            return;
        if (grid[i][j] == 0 || visitedGrid[i][j] == true)
            return;

        visitedGrid[i][j] = true;
        currentArea += 1;

        traverse(i + 1, j);
        traverse(i - 1, j);
        traverse(i, j + 1);
        traverse(i, j - 1);
    }

    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        visitedGrid = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && visitedGrid[i][j] == false) {
                    this.currentArea = 0;
                    traverse(i, j);
                    maxArea = Math.max(maxArea, currentArea);
                }
            }
        }

        return maxArea;
    }
}