class Solution {
    int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};
    
    
    public int numEnclaves(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        for(int i=0; i<rows; i++){
            if(grid[i][0] == 1){
                floodfill(grid, i, 0, 1, 0);
            }
            if(grid[i][cols-1] == 1){
                floodfill(grid, i, cols-1, 1, 0);
            }
        }

        for(int j=0; j<cols; j++){
            if(grid[0][j] == 1){
                floodfill(grid, 0, j, 1, 0);
            }
            if(grid[rows-1][j] == 1){
                floodfill(grid, rows-1, j, 1, 0);
            }
        }

        int count = 0;
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(grid[i][j] == 1){
                    count += 1;
                }
            }
        }

        return count;
    }

    private void floodfill(int[][] grid, int i, int j, int originalColor, int targetColor){
        int m = grid.length;
        int n = grid[0].length;
        if((i < 0 || j < 0 || i >= m || j >= n) || grid[i][j] != originalColor || grid[i][j] == targetColor){
            return;
        }

        grid[i][j] = targetColor;
        for(int k=0; k<4; k++){
            int newI = i + dy[k];
            int newJ = j + dx[k];
            floodfill(grid, newI, newJ, originalColor, targetColor);
        }
    }
}