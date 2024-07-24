import java.util.HashSet;
import java.util.ArrayList;

class Solution {
    private boolean containsDuplicates(ArrayList<Character> arr){
        HashSet<Character> set = new HashSet<Character>();
        for(Character c: arr){
            if(set.contains(c)) return true;
            else set.add(c);
        }
        return false;
    }

    private boolean validateRowAndColumn(char[][] board){
        ArrayList<Character> row = new ArrayList<Character>();
        ArrayList<Character> col = new ArrayList<Character>();
        for(int i=0; i<9; i++){
            row.clear();
            col.clear();
            for(int j=0; j<9; j++){
                if(board[i][j]!='.') row.add(board[i][j]);
                if(board[j][i]!='.') col.add(board[j][i]);
            }
            if(containsDuplicates(row) || containsDuplicates(col)) return false;
        }
        return true;
    }
    
    /*
     * THIS hashIndex function is the CRUX of validateSubBoxes()
     *  Basically from the row, col: we are trying to find which square does the number fall into
     */

    private int hashIndex(int row, int col){
        return ((int)row/3 * 3 + (int)col/3);
    }

    private boolean validateSubBoxes(char[][] board){
        ArrayList<ArrayList<Character>> squares = new ArrayList<ArrayList<Character>>();
        for(int i = 0; i < 9; i++) {
            squares.add(new ArrayList<Character>());
        }

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j]!='.'){
                    int index = hashIndex(i,j);
                    squares.get(index).add(board[i][j]);
                }
            }
        }

        for(ArrayList<Character> square: squares){
            if(containsDuplicates(square)) return false;
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        return validateRowAndColumn(board)&&validateSubBoxes(board);
    }
}