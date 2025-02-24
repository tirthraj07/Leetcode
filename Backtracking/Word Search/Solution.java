class Solution {
	private boolean doesWordExists = false;
	private int m, n;
	private char[][] board;
	private boolean[][] pathTravelled;

	private void traverse(int i, int j, int currentIndex, String word) {
		if (currentIndex == word.length()) {
			doesWordExists = true;
			return;
		}
		if (doesWordExists == true)
			return;
		if (i < 0 || j < 0 || i >= m || j >= n)
			return;
		if (pathTravelled[i][j] == true)
			return;

		pathTravelled[i][j] = true;

		if (board[i][j] == word.charAt(currentIndex)) {
			// search down
			traverse(i, j + 1, currentIndex + 1, word);
			if (doesWordExists == true)
				return;

			// search up
			traverse(i, j - 1, currentIndex + 1, word);
			if (doesWordExists == true)
				return;

			// search left
			traverse(i - 1, j, currentIndex + 1, word);
			if (doesWordExists == true)
				return;

			// right
			traverse(i + 1, j, currentIndex + 1, word);
			if (doesWordExists == true)
				return;
		}

		pathTravelled[i][j] = false;
	}

	public boolean exist(char[][] board, String word) {
		this.board = board;
		this.m = board.length;
		this.n = board[0].length;
		pathTravelled = new boolean[m][n];

		for (int i = 0; i < m; i++) {
			if (doesWordExists == true)
				break;
			for (int j = 0; j < n; j++) {
				if (doesWordExists == true)
					break;
				traverse(i, j, 0, word);
			}
		}

		return doesWordExists;
	}
}