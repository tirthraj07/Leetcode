class Solution {
    private int climbStairs(int n, int[] dp, int[] cost) {
        if (n == 0 || n == 1) {
            return dp[n];
        }
        if (dp[n] == 0)
            dp[n] = Math.min(cost[n - 1] + climbStairs(n - 1, dp, cost), cost[n - 2] + climbStairs(n - 2, dp, cost));
        return dp[n];
    }

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;

        climbStairs(n, dp, cost);

        return dp[n];
    }
}

class Solution2 {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(cost[i - 1] + dp[i - 1], cost[i - 2] + dp[i - 2]);
        }

        return dp[n];

    }
}