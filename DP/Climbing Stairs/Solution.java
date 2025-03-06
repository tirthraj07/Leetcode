
// Without Memorization -> Time Limit Exceeded

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int climbStairs(int n) {
        if (n == 1)
            return 1;
        else if (n == 2)
            return 2;
        else
            return climbStairs(n - 1) + climbStairs(n - 2);
    }
}

// With Memorization + Top Down Approach
class Solution2 {
    private Map<Integer, Integer> mp = new HashMap<>() {
        {
            put(1, 1);
            put(2, 2);
        }
    };

    public int climbStairs(int n) {
        if (!mp.containsKey(n)) {
            mp.put(n, climbStairs(n - 1) + climbStairs(n - 2));
        }
        return mp.get(n);
    }
}

// Memorization without hashmap + Top Down Approach
class Solution3 {

    private int helper(int n, int[] dp) {
        if (n == 1 || n == 2)
            return n;

        if (dp[n] == 0) {
            dp[n] = helper(n - 1, dp) + helper(n - 2, dp);
        }

        return dp[n];
    }

    public int climbStairs(int n) {
        if (n == 1)
            return 1; // edge case
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        return helper(n, dp);
    }
}

// Memorization + Bottom Up Approach
class Solution4 {
    public int climbStairs(int n) {
        if (n == 1 || n == 2)
            return n;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}

// Optimization -> Basically Fibonacci
class Solution5 {
    public int climbStairs(int n) {
        if (n == 1 || n == 2)
            return n;
        int prev1 = 1;
        int prev2 = 2;
        int curr = 3;
        for (int i = 4; i <= n; i++) {
            prev1 = prev2;
            prev2 = curr;
            curr = prev1 + prev2;
        }

        return curr;
    }
}