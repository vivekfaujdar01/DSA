class Solution {
    // Tabulation
    public int fib(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        if(n<=1){
            return n;
        }
        dp[0] = 0;
        dp[1] = 1;

        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
    // int rec(int n, int[] dp){
    //     // base cond.
    //     if(n==0 || n==1){
    //         return n;
    //     }

    //     if(dp[n] != -1){
    //         return dp[n];
    //     } 

    //     return dp[n] = rec(n-1, dp) + rec(n-2, dp);
    // }
}