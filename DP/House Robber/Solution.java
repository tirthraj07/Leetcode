class Solution {
    int[] maxMoneyArr;

    private int dfs(int[] nums, int index) {
        if (index >= nums.length) {
            return 0;
        } else if (maxMoneyArr[index] != -1) {
            return maxMoneyArr[index];
        }

        maxMoneyArr[index] = nums[index] + Math.max(dfs(nums, index + 2), dfs(nums, index + 3));
        return maxMoneyArr[index];
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];
        maxMoneyArr = new int[n];
        for (int i = 0; i < n; i++)
            maxMoneyArr[i] = -1;

        return Math.max(dfs(nums, 0), dfs(nums, 1));
    }
}
