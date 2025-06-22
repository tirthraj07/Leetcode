class Solution3 {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int n_squared = n * n;

        // n_squared is cast to long, then multiplied - no overflow on 562 / 584 
        long expectedSum = (long) ((long) n_squared*(n_squared + 1))/2;
        long expectedSquaredSum = (long) ((long) n_squared*(n_squared + 1)*(2*n_squared + 1))/6;

        long actualSum = 0;
        long actualSquaredSum = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                actualSum += (long) grid[i][j];
                actualSquaredSum += (long) grid[i][j] * grid[i][j];
            }
        }

        // x = missingNumber
        // y = repeatedNumber
        // x - y = expectedSum - actualSum = diff
        long diff = expectedSum - actualSum;

        // x^2 - y^2 = expectedSquaredSum - actualSquaredSum
        long squaredDiff = expectedSquaredSum - actualSquaredSum;
        // x^2 - y^2 = (x-y)(x+y) = squaredDiff
        // x + y = squaredDiff / (x-y) = squaredDiff / diff
        long sum = squaredDiff / diff;

        // 2x = diff + sum
        // x = (diff + sum) / 2
        int missingNumber = (int)((sum + diff)/2);
        // 2y = (sum - diff)
        // y = (sum - diff)/2
        int repeatedNumber = (int)((sum - diff)/2);
        return new int[]{repeatedNumber, missingNumber};
    }
}