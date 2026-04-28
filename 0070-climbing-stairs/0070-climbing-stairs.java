class Solution {
    public int climbStairs(int n) {
        int dp[] = new int[n+1];

        for(int i=0;i<=n;i++){
            dp[i] = -1;
        }
        
        return rec(n, dp);
    }
    public int rec(int n, int[] dp){
        if(n == 0 || n == 1){
            return 1;
        }    

        if(dp[n] != -1) return dp[n];

        return dp[n] = rec(n-1, dp) + rec(n-2, dp);
    }
}