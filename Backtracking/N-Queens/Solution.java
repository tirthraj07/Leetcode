import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<List<String>> res;
    private char[][] board;
    private int n;

    private boolean safeToPlaceQueen(int i, int j) {
        if (board[i][j] == 'Q')
            return false;

        // check row (unnecessary since we are placing one queen per row)
        // for (int col = 0; col < n; col++) {
        // if (board[i][col] == 'Q')
        // return false;
        // }

        // check column
        for (int row = 0; row < n; row++) {
            if (board[row][j] == 'Q')
                return false;
        }

        // check diagonal top-left to bottom-right

        // from (i,j) to top left
        for (int row = i, col = j; row >= 0 && col >= 0; row--, col--) {
            if (board[row][col] == 'Q')
                return false;
        }

        // from (i,j) to bottom right (unnecessary as there are now queens in columns
        // below j)
        // for (int row = i, col = j; row < n && col < n; row++, col++) {
        // if (board[row][col] == 'Q')
        // return false;
        // }

        // check diagonal top-right to bottom-left;
        // from (i,j) to top right
        for (int row = i, col = j; row >= 0 && col < n; row--, col++) {
            if (board[row][col] == 'Q')
                return false;
        }

        // from (i,j) to bottom-left (unnecessary as there are no queens in columns
        // below j)
        // for (int row = i, col = j; row < n && col >= 0; row++, col--) {
        // if (board[row][col] == 'Q')
        // return false;
        // }

        return true;
    }

    private void addBoardToRes() {
        List<String> chessboardToBeAdded = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            chessboardToBeAdded.add(new String(board[i]));
        }
        res.add(chessboardToBeAdded);
    }

    private void solve(int remainingQueens) {
        if (remainingQueens == 0) {
            addBoardToRes();
            return;
        }

        int row = n - remainingQueens;
        for (int col = 0; col < n; col++) {
            if (safeToPlaceQueen(row, col)) {
                board[row][col] = 'Q';
                solve(remainingQueens - 1);
                board[row][col] = '.';
            }
        }

    }

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        res = new ArrayList<>();
        board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        solve(n);

        return res;
    }
}