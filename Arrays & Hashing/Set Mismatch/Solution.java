class Solution {
    public int[] findErrorNums(int[] nums) {
        int n = nums.length;

        long expectedSum = ((long) n * (n + 1))/2;
        long expectedSquaredSum = ((long) n * (n + 1) * (2 * n + 1))/6;

        long actualSum = 0;
        long actualSquaredSum = 0;
        for(int i=0; i<n; i++){
            actualSum += nums[i];
            actualSquaredSum += (long) nums[i] * nums[i];
        }
        
        // x = missing number
        // y = repeated number
        // x - y = expectedSum - actualSum
        long diff = expectedSum - actualSum;

        // x^2 - y^2 = expectedSquaredSum - actualSquaredSum
        long squaredDiff = expectedSquaredSum - actualSquaredSum;

        // (x + y) = (squaredDiff) / diff
        long sum = squaredDiff / diff;

        int missingNumber = (int) ((sum + diff) / 2);
        int repeatedNumber = (int) ((sum - diff) / 2);
        return new int[]{repeatedNumber, missingNumber};
    }
}