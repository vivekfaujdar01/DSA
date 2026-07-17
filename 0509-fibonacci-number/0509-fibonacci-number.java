class Solution {
    // recursion
    public int fib(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return rec(n, dp);
    }
    int rec(int n, int[] dp){
        // base cond.
        if(n==0 || n==1){
            return n;
        }

        if(dp[n] != -1){
            return dp[n];
        } 

        return dp[n] = rec(n-1, dp) + rec(n-2, dp);
    }
}