class Solution {
    public int missingNumber(int[] nums) {
        int N = nums.length;
        int actualSum = (N * (N + 1)) / 2;

        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        return actualSum - totalSum;
    }
}