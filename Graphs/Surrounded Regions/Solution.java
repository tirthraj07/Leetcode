class Solution {
    char[][] board;
    boolean[][] visited;
    int m;
    int n;

    private void dfs(int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n)
            return;
        if (visited[i][j] || board[i][j] == 'X')
            return;

        visited[i][j] = true;
        // up
        dfs(i - 1, j);
        // down
        dfs(i + 1, j);
        // left
        dfs(i, j - 1);
        // right
        dfs(i, j + 1);
    }

    public void solve(char[][] board) {
        this.board = board;
        this.m = board.length;
        this.n = board[0].length;
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O' && !visited[i][0]) {
                dfs(i, 0);
            }
            if (board[i][n - 1] == 'O' && !visited[i][n - 1]) {
                dfs(i, n - 1);
            }
        }

        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O' && !visited[0][j]) {
                dfs(0, j);
            }
            if (board[m - 1][j] == 'O' && !visited[m - 1][j]) {
                dfs(m - 1, j);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }

    }
}

// With O(1) Space

class Solution2 {
    char[][] board;
    int m;
    int n;

    private void dfs(int i, int j) {
        if (i < 0 || j < 0 || i >= m || j >= n)
            return;
        if (board[i][j] == 'T' || board[i][j] == 'X')
            return;

        board[i][j] = 'T';
        // up
        dfs(i - 1, j);
        // down
        dfs(i + 1, j);
        // left
        dfs(i, j - 1);
        // right
        dfs(i, j + 1);
    }

    public void solve(char[][] board) {
        this.board = board;
        this.m = board.length;
        this.n = board[0].length;

        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                dfs(i, 0);
            }
            if (board[i][n - 1] == 'O') {
                dfs(i, n - 1);
            }
        }

        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                dfs(0, j);
            }
            if (board[m - 1][j] == 'O') {
                dfs(m - 1, j);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }

    }
}