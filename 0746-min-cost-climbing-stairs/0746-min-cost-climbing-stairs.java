class Solution {
    // using recursion to solve this but we can change it into dp (tabulation, memoisation)
    public int rec(int n, int[] cost, int[] dp){
        if(n == 0 || n == 1){
            return 0;
        }
        if(n < 0)   return 0;
        if(dp[n] != -1){
            return dp[n];
        }
        int pick = cost[n-1] + rec(n-1, cost, dp);
        int notpick = cost[n-2] + rec(n-2, cost, dp);
        return dp[n] = Math.min(pick,notpick);
    }
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n+1];
        for(int i = 0; i < n+1; i++){
            dp[i] = -1;
        }
        rec(n, cost, dp);
        return dp[n];
    }
}

// other thinking

// public int minCostClimbingStairs(int[] cost) {
//     int n = cost.length;
//     return Math.min(solve(cost, n - 1), solve(cost, n - 2));
// }
// private int solve(int[] cost, int i) {
//     if (i < 0) return 0;
//     if (i == 0 || i == 1) return cost[i];
//     return cost[i] + Math.min(solve(cost, i - 1), solve(cost, i - 2));
// }
