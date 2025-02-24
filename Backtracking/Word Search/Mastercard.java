@SuppressWarnings("all")
public class Mastercard {
    // Given a grid and word, find occurrence of a given word in the grid
    // The word can be found in horizontal, vertical or in diagonal way

    private int count = 0;
    private int m, n;
    private char[][] grid;
    private boolean[][] hasTraveled;

    private void traverse(int i, int j, int currentIndex, String word, int prevMove) {
        if (i < 0 || j < 0 || i >= m || j >= n)
            return;
        if (hasTraveled[i][j] == true)
            return;
        if (grid[i][j] != word.charAt(currentIndex))
            return;

        if (currentIndex == word.length() - 1) {
            count += 1;
            return;
        }

        hasTraveled[i][j] = true;

        // if currentIndex = 0, you can move in all direction
        // if not, then you need to move based on the previous move
        /*
         * prevMove :
         * 0 -> Move Vertical
         * 1 -> Move Horizontal
         * 2 -> Move Diagonally along principle axis -> (i+1, j+1), (i-1, j-1)
         * 3 -> Move Diagonally along non-principle axis -> (i+1, j-1), (i-1),(j+1)
         */

        // Vertical
        if (currentIndex == 0 || prevMove == 0) {
            // down
            traverse(i + 1, j, currentIndex + 1, word, 0);
            // up
            traverse(i - 1, j, currentIndex + 1, word, 0);
        }

        // Horizontal
        if (currentIndex == 0 || prevMove == 1) {
            // left
            traverse(i, j - 1, currentIndex + 1, word, 1);
            // right
            traverse(i, j + 1, currentIndex + 1, word, 1);
        }

        // Diagonal Along Principle Axis
        if (currentIndex == 0 || prevMove == 2) {
            // up-left
            traverse(i - 1, j - 1, currentIndex + 1, word, 2);
            // down-right
            traverse(i + 1, j + 1, currentIndex + 1, word, 2);
        }

        // Diagonal Along Non-Principle Axis
        if (currentIndex == 0 || prevMove == 3) {
            // up-right
            traverse(i - 1, j + 1, currentIndex + 1, word, 3);
            // down-left
            traverse(i + 1, j - 1, currentIndex + 1, word, 3);
        }

        hasTraveled[i][j] = false;
    }

    public int solution(char[][] grid, String word) {
        this.grid = grid;
        this.m = grid.length;
        this.n = grid[0].length;
        this.hasTraveled = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                traverse(i, j, 0, word, 0);
            }
        }

        return count;
    }

    public static void main(String[] args) {

        // test case 1
        Mastercard testcase1 = new Mastercard();
        char[][] grid1 = {
                { 'M', 'A', 'S', 'T' },
                { 'A', 'S', 'T', 'E' },
                { 'S', 'T', 'E', 'R' },
                { 'T', 'E', 'R', 'C' }
        };
        String word1 = "AST";

        // Solution -> 2xVertical + 2xHorizontal = 4
        System.out.println("Test Case 1 : " + testcase1.solution(grid1, word1)); // 4

        // Test case 2
        Mastercard testcase2 = new Mastercard();
        char[][] grid2 = {
                { 'C', 'A', 'T' },
                { 'C', 'A', 'T' },
                { 'C', 'A', 'T' }
        };
        String word2 = "CAT";
        // Solution -> 3xHorizontal + 2xDiagonalAlongPrincipleAxis = 5
        System.out.println("Test Case 2 : " + testcase2.solution(grid2, word2)); // 5

        // Test case 3
        Mastercard testcase3 = new Mastercard();
        char[][] grid3 = {
                { 'A', 'X', 'X', 'X' },
                { 'X', 'B', 'X', 'X' },
                { 'X', 'X', 'C', 'X' },
                { 'X', 'X', 'X', 'D' }
        };
        String word3 = "ABCD";
        // Solution -> 1xDiagonalAlongPrincipleAxis = 1
        System.out.println("Test Case 3 : " + testcase3.solution(grid3, word3)); // 1

        // Test case 4
        Mastercard testcase4 = new Mastercard();
        char[][] grid4 = {
                { 'X', 'X', 'X', 'A' },
                { 'X', 'X', 'B', 'X' },
                { 'X', 'C', 'X', 'X' },
                { 'D', 'X', 'X', 'X' }
        };
        String word4 = "ABCD";
        // Solution -> 1xDiagonalAlongNonPrincipleAxis = 1
        System.out.println("Test Case 4 : " + testcase4.solution(grid4, word4)); // 1

        // Test case 5
        Mastercard testcase5 = new Mastercard();
        char[][] grid5 = {
                { 'H', 'E', 'L', 'L' },
                { 'L', 'O', 'X', 'X' },
                { 'X', 'X', 'X', 'X' },
                { 'X', 'X', 'X', 'X' }
        };
        String word5 = "WORLD";
        // Solution -> 0
        System.out.println("Test Case 5 : " + testcase5.solution(grid5, word5)); // 0

        // Test case 6
        Mastercard testcase6 = new Mastercard();
        char[][] grid6 = {
                { 'A', 'A', 'A', 'A' },
                { 'A', 'A', 'A', 'A' },
                { 'A', 'A', 'A', 'A' },
                { 'A', 'A', 'A', 'A' }
        };
        String word6 = "A";
        // Solution -> 0
        System.out.println("Test Case 6 : " + testcase6.solution(grid6, word6)); // 0

    }

}
