import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;


        int COLUMN_MIN = 0;
        int COLUMN_MAX = n-1;

        int ROW_MIN = 0;
        int ROW_MAX = m-1;

        List<Integer> sol = new ArrayList<>();


        while(COLUMN_MIN <= COLUMN_MAX && ROW_MIN <= ROW_MAX){
            addLeftToRight(sol, matrix, COLUMN_MIN, COLUMN_MAX, ROW_MIN, ROW_MAX);
            ROW_MIN += 1;
            addTopToBottom(sol, matrix, COLUMN_MIN, COLUMN_MAX, ROW_MIN, ROW_MAX);
            COLUMN_MAX -= 1;
            addRightToLeft(sol, matrix, COLUMN_MIN, COLUMN_MAX, ROW_MIN, ROW_MAX);
            ROW_MAX -= 1;
            addBottomToTop(sol, matrix, COLUMN_MIN, COLUMN_MAX, ROW_MIN, ROW_MAX);
            COLUMN_MIN += 1;
        }   

        return sol;
    }

    private void addLeftToRight(List<Integer> sol,int[][] matrix,int COLUMN_MIN,int COLUMN_MAX,int ROW_MIN,int ROW_MAX){
        for(int i=COLUMN_MIN; i<=COLUMN_MAX; i++){
            sol.add(matrix[ROW_MIN][i]);
        }
    }

    private void addTopToBottom(List<Integer> sol,int[][] matrix,int COLUMN_MIN,int COLUMN_MAX,int ROW_MIN,int ROW_MAX){
        for(int i=ROW_MIN; i<=ROW_MAX; i++){
            sol.add(matrix[i][COLUMN_MAX]);
        }
    }

    private void addRightToLeft(List<Integer> sol,int[][] matrix,int COLUMN_MIN,int COLUMN_MAX,int ROW_MIN,int ROW_MAX){
        if(ROW_MIN <= ROW_MAX){
            for(int i=COLUMN_MAX; i>= COLUMN_MIN; i--){
                sol.add(matrix[ROW_MAX][i]);
            }
        }
    }

    private void addBottomToTop(List<Integer> sol,int[][] matrix,int COLUMN_MIN,int COLUMN_MAX,int ROW_MIN,int ROW_MAX){
        if(COLUMN_MIN <= COLUMN_MAX){
            for(int i=ROW_MAX; i>=ROW_MIN; i--){
                sol.add(matrix[i][COLUMN_MIN]);
            }
        }
    }

}