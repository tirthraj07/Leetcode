import java.util.Set;
import java.util.HashSet;
import java.util.Objects;

@SuppressWarnings("unused")

class Solution {
    
    private class Pair<L, R> {
        private final L left;
        private final R right;

        public Pair(L left, R right) {
            this.left = left;
            this.right = right;
        }

        public L getLeft() {
            return left;
        }

        public R getRight() {
            return right;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;
            Pair<?, ?> pair = (Pair<?, ?>) o;
            return Objects.equals(left, pair.left) && Objects.equals(right, pair.right);
        }

        @Override
        public int hashCode() {
            return Objects.hash(left, right);
        }

        @Override
        public String toString() {
            return "(" + left + ", " + right + ")";
        }
    }


    
    public void setZeroes(int[][] matrix) {
        Set<Pair<Integer,Integer>> marked = new HashSet<>();
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(matrix[i][j] == 0){
                    marked.add(new Pair<Integer,Integer>(i, j));
                }
            }
        }

        for(Pair<Integer,Integer> p: marked){
            int row = p.left;
            int col = p.right;
            markRow(matrix, row);
            markCol(matrix, col);
        }
    }

    private void markRow(int[][] matrix, int row){
        for(int i=0; i<matrix[0].length; i++){
            matrix[row][i] = 0;
        }
    }

    private void markCol(int[][] matrix, int col){
        for(int i=0; i<matrix.length; i++){
            matrix[i][col] = 0;
        }
    }
}