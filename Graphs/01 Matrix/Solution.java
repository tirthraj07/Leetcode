import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings("all")
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> q = new LinkedList<>();
        int m = mat.length;
        int n = mat[0].length;
        int[][] output = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    output[i][j] = 0;
                    q.offer(new int[] { i, j });
                } else {
                    output[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] arr = q.poll();
            int i = arr[0];
            int j = arr[1];

            // up
            if (i - 1 >= 0 && output[i - 1][j] > output[i][j] + 1) {
                output[i - 1][j] = 1 + output[i][j];
                q.offer(new int[] { i - 1, j });
            }
            // down
            if (i + 1 < m && output[i + 1][j] > output[i][j] + 1) {
                output[i + 1][j] = 1 + output[i][j];
                q.offer(new int[] { i + 1, j });
            }
            // left
            if (j - 1 >= 0 && output[i][j - 1] > output[i][j] + 1) {
                output[i][j - 1] = 1 + output[i][j];
                q.offer(new int[] { i, j - 1 });
            }
            // right
            if (j + 1 < n && output[i][j + 1] > output[i][j] + 1) {
                output[i][j + 1] = 1 + output[i][j];
                q.offer(new int[] { i, j + 1 });
            }
        }

        return output;

    }
}