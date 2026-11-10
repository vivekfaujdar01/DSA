// f(n-1)+costs[n]+(n-(n-1))^2 = f(n-1)+costs[n]+1
// f(n-2)+costs[n]+(n-(n-2))^2 = f(n-2)+costs[n]+4
// f(n-3)+costs[n]+(n-(n-3))^2 = f(n-3)+costs[n]+9
// Memoization (Top-Down DP)
// Time	Complexity: (O(n)
class Solution {
    public int climbStairs(int n, int[] costs) {

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return solve(n, costs, dp);
    }
    private int solve(int i, int[] costs, int[] dp) {
        
        if (i == 0) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int minCost = Integer.MAX_VALUE;

        minCost = Math.min(minCost, solve(i - 1, costs, dp) + costs[i - 1] + 1);

        if (i >= 2) {
            minCost = Math.min(minCost, solve(i - 2, costs, dp) + costs[i - 1] + 4);
        }

        if (i >= 3) {
            minCost = Math.min(minCost, solve(i - 3, costs, dp) + costs[i - 1] + 9);
        }

        dp[i] = minCost ;

        return dp[i];
    }
}