class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return rec(n - 1, dp);
    }

    private int rec(int i, int[] dp) {
        if (i == 0 || i == 1){ // dp[0] is storing result for stair 1 & dp[1] is storing result for stair 2;
            return dp[i] = i+1;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        return dp[i] = rec(i - 1, dp) + rec(i - 2, dp);
    }
}