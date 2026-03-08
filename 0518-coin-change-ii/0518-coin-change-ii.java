class Solution {
    // tabulation approach (bottom - up)
    public int change(int amount, int[] coins) {

        int n = coins.length;

        int[][] dp = new int[n][amount + 1];

        // base case
        for(int a = 0; a <= amount; a++){
            if(a % coins[0] == 0){
                dp[0][a] = 1;
            }
                
        }

        for(int i = 1; i < n; i++){
            for(int a = 0; a <= amount; a++){

                int notTake = dp[i-1][a];

                int take = 0;
                if(coins[i] <= a){
                    take = dp[i][a - coins[i]];
                }

                dp[i][a] = take + notTake;
            }
        }

        return dp[n-1][amount];
    }
}

// Memoization
// int solve(int index, int amount, int[] coins, int[][] dp) {

//     if (index == 0) {
//         if (amount % coins[0] == 0)
//             return 1;
//         return 0;
//     }

//     if (dp[index][amount] != -1){
//          return dp[index][amount];
//      }

//     int notTake = solve(index - 1, amount, coins, dp);

//     int take = 0;
//     if (coins[index] <= amount) {
//         take = solve(index, amount - coins[index], coins, dp);
//     }

//     return dp[index][amount] = take + notTake;
// }