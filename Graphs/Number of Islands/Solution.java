class Solution {
    private int count;
    private boolean[][] visitedGrid;
    private char[][] grid;
    private int m;
    private int n;

    private void traverse(int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n)
            return;
        if (grid[i][j] == '0' || visitedGrid[i][j] == true)
            return;

        visitedGrid[i][j] = true;
        traverse(i + 1, j);
        traverse(i - 1, j);
        traverse(i, j + 1);
        traverse(i, j - 1);
    }

    public int numIslands(char[][] grid) {
        this.grid = grid;
        count = 0;
        this.m = grid.length;
        this.n = grid[0].length;
        visitedGrid = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && visitedGrid[i][j] == false) {
                    traverse(i, j);
                    count += 1;
                }
            }
        }

        return count;
    }
}