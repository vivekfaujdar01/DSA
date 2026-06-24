class Solution {
    public int climbStairs(int n) {
        int dp[] = new int[n];

        for(int i=0;i<n;i++){
            dp[i] = -1;
        }
        
        return rec(n-1, dp);
    }
    public int rec(int n, int[] dp){
        if(n==0){
            return 1;
        }
        if(n == -1){
            return 1;
        }
        if(n < -1){
            return 0;
        }

        if(dp[n] != -1){
            return dp[n];
        }

        int jump1 = rec(n-1, dp);
        int jump2 = rec(n-2, dp);

        return dp[n] = jump1 + jump2;
    }
}