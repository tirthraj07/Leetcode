// This is a leetcode premium problem
// Similar problem can be found on https://neetcode.io/problems/islands-and-treasure

import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings("all")
class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    q.offer(new int[] { i, j });
                }
            }
        }

        while (!q.isEmpty()) {
            int[] arr = q.poll();
            int i = arr[0];
            int j = arr[1];

            // up
            if (i - 1 >= 0 && grid[i - 1][j] != -1 && grid[i - 1][j] > 1 + grid[i][j]) {
                grid[i - 1][j] = 1 + grid[i][j];
                q.offer(new int[] { i - 1, j });
            }

            // down
            if (i + 1 < m && grid[i + 1][j] != -1 && grid[i + 1][j] > 1 + grid[i][j]) {
                grid[i + 1][j] = 1 + grid[i][j];
                q.offer(new int[] { i + 1, j });
            }

            // left
            if (j - 1 >= 0 && grid[i][j - 1] != -1 && grid[i][j - 1] > 1 + grid[i][j]) {
                grid[i][j - 1] = 1 + grid[i][j];
                q.offer(new int[] { i, j - 1 });
            }

            // right
            if (j + 1 < n && grid[i][j + 1] != -1 && grid[i][j + 1] > 1 + grid[i][j]) {
                grid[i][j + 1] = 1 + grid[i][j];
                q.offer(new int[] { i, j + 1 });
            }

        }

    }
}
