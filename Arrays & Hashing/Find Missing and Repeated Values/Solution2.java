class Solution2 {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int N = grid.length;
        int size = N * N;
        int[] count = new int[size + 1];
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                count[grid[i][j]] += 1;
            }
        }

        int missingNumber = 0;
        int repeatedNumber = 0;
        for(int i=0; i<size + 1; i++){
            if(count[i] == 0){
                missingNumber = i;
            }
            if(count[i] == 2){
                repeatedNumber = i;
            }
        }

        return new int[]{repeatedNumber, missingNumber};

    }
}