import java.util.LinkedList;
import java.util.Queue;

@SuppressWarnings("all")
class Solution {
    private class Pair<K, V> {
        public K first;
        public V second;

        public Pair(K first, V second) {
            this.first = first;
            this.second = second;
        }
    }

    public int orangesRotting(int[][] grid) {
        int time = 0;
        int m = grid.length;
        int n = grid[0].length;

        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        boolean freshOrangeExist = false;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new Pair(i, j));
                } else if (grid[i][j] == 1) {
                    freshOrangeExist = true;
                }
            }
        }

        if (freshOrangeExist == false)
            return 0;

        if (q.isEmpty())
            return -1;

        q.offer(null);

        while (!q.isEmpty()) {
            Pair<Integer, Integer> pair = q.poll();
            if (pair != null) {
                int i = pair.first;
                int j = pair.second;

                // up
                if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                    grid[i - 1][j] = 2;
                    q.offer(new Pair(i - 1, j));
                }

                // down
                if (i + 1 < m && grid[i + 1][j] == 1) {
                    grid[i + 1][j] = 2;
                    q.offer(new Pair(i + 1, j));
                }

                // left
                if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                    grid[i][j - 1] = 2;
                    q.offer(new Pair(i, j - 1));
                }

                // right
                if (j + 1 < n && grid[i][j + 1] == 1) {
                    grid[i][j + 1] = 2;
                    q.offer(new Pair(i, j + 1));
                }

            } else {
                time += 1;
                if (!q.isEmpty()) {
                    q.offer(null);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return time;
    }
}