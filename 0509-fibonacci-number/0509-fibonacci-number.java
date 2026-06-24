class Solution {
    
    public int fib(int n) {
        if(n == 0){
            return 0;
        }

        int prev2 = 0;
        int prev1 = 1;
        
        for(int i=2;i<=n;i++){
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }
}
// Tabulation (bottom - up)

// int[] dp = new int[n+1];
// Arrays.fill(dp, -1);
// dp[0] = 0;
// dp[1] = 1;
// for(int i=2;i<=n;i++){
//     dp[i] = dp[i-1] + dp[i-2];
// }
// return dp[n];

// Memoization (top - down)
// public int rec(int n, int[] dp){
//     if(n<=1){
//         return n;
//     } 
//     if(dp[n] != -1){
//         return dp[n];
//     }
//     return dp[n] = fib(n-1) + fib(n-2);
// }