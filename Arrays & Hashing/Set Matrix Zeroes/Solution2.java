
@SuppressWarnings("unused")

public class Solution2 {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean[] rowMarked = new boolean[m];
        boolean[] colMarked = new boolean[n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == 0){
                    rowMarked[i] = true;
                    colMarked[j] = true;
                }
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                matrix[i][j] = (rowMarked[i] || colMarked[j]) ? 0: matrix[i][j];
            }
        }

    }
}
