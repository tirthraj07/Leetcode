class Solution {
    public void rotate(int[][] matrix) {
        transposeMatrix(matrix);
        reverseColumns(matrix);
    }

    private void transposeMatrix(int[][] matrix){
        int N = matrix.length;

        for(int i=0; i<N; i++){
            for(int j = 0; j<N; j++){
                if(i == j){
                    break;
                }

                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

    }

    private void reverseColumns(int[][] matrix){
        int N = matrix.length;
        int i = 0;
        int j = N - 1;
        while(i < j){
            for(int row = 0; row<N; row++){
                int temp = matrix[row][i];
                matrix[row][i] = matrix[row][j];
                matrix[row][j] = temp;
            }
            i++;
            j--;
        }
    }

}