class Solution {
    public int climbStairs(int n) {
        int dp[] = new int[n+1];

        for(int i=0;i<=n;i++){
            dp[i] = -1;
        }
        
        return rec(n, dp);
    }
    public int rec(int n, int[] dp){
        if(n == 0){
            return 1;
        }    

        if(dp[n] != -1) return dp[n];

        int jump1 = rec(n-1, dp);

        int jump2 = 0;

        if(n > 1){
            jump2 += rec(n-2, dp);
        }
        return dp[n] = jump1 + jump2;
    }
}