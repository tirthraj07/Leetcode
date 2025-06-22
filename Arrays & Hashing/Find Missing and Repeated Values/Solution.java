import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int N = grid.length;
        int M = N * N;
        int expectedTotalSum = (M*(M+1))/2;
        
        int repeatedNumber = 0;
        int actualTotalSum = 0;
        Set<Integer> seenIntegers = new HashSet<>();

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(seenIntegers.contains(grid[i][j])){
                    repeatedNumber = grid[i][j];
                }
                seenIntegers.add(grid[i][j]);
                actualTotalSum += grid[i][j];
            }
        }

        int missingNumber = expectedTotalSum - actualTotalSum + repeatedNumber;
        return new int[]{repeatedNumber, missingNumber};
    }   
}