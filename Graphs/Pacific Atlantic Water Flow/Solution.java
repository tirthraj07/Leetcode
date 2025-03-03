import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    private int m;
    private int n;

    private class Node {
        public int height;
        public boolean canReachPacificOcean;
        public boolean canReachAtlanticOcean;

        public Node(int height) {
            this.height = height;
            canReachAtlanticOcean = false;
            canReachPacificOcean = false;
        }
    }

    private void dfs(int i, int j, Node[][] nodes, boolean[][] visited, boolean isPacific) {
        if (visited[i][j])
            return;

        visited[i][j] = true;
        if (isPacific) {
            nodes[i][j].canReachPacificOcean = true;
        } else {
            nodes[i][j].canReachAtlanticOcean = true;
        }

        // up
        if (i - 1 >= 0 && visited[i - 1][j] == false && nodes[i - 1][j].height >= nodes[i][j].height) {
            dfs(i - 1, j, nodes, visited, isPacific);
        }
        // down
        if (i + 1 < m && visited[i + 1][j] == false && nodes[i + 1][j].height >= nodes[i][j].height) {
            dfs(i + 1, j, nodes, visited, isPacific);
        }
        // left
        if (j - 1 >= 0 && visited[i][j - 1] == false && nodes[i][j - 1].height >= nodes[i][j].height) {
            dfs(i, j - 1, nodes, visited, isPacific);
        }
        // right
        if (j + 1 < n && visited[i][j + 1] == false && nodes[i][j + 1].height >= nodes[i][j].height) {
            dfs(i, j + 1, nodes, visited, isPacific);
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        this.m = heights.length;
        this.n = heights[0].length;

        Node[][] nodes = new Node[m][n];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                nodes[i][j] = new Node(heights[i][j]);

        boolean[][] pacificVisited = new boolean[m][n];
        boolean[][] atlanticVisited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(i, 0, nodes, pacificVisited, true);
            dfs(i, n - 1, nodes, atlanticVisited, false);
        }
        for (int j = 0; j < n; j++) {
            dfs(0, j, nodes, pacificVisited, true);
            dfs(m - 1, j, nodes, atlanticVisited, false);
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (nodes[i][j].canReachPacificOcean && nodes[i][j].canReachAtlanticOcean) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;

    }
}