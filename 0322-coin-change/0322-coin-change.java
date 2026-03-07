class Solution {
    // tabulation approach
    public int coinChange(int[] coins, int amount) {

        int n = coins.length;
        int[][] dp = new int[n][amount + 1]; // {index, amount+1}
        int INF = (int)1e9;

        // Base case
        for (int a = 0; a <= amount; a++) {

            if (a % coins[0] == 0){
                dp[0][a] = a / coins[0];
            }
            else{
                dp[0][a] = INF;
            }
        }

        // Fill table
        for (int i = 1; i < n; i++) {
            for (int a = 0; a <= amount; a++) {

                int notTake = dp[i - 1][a];

                int take = INF;
                if (coins[i] <= a) {
                    take = 1 + dp[i][a - coins[i]]; // stay at the same index
                }

                dp[i][a] = Math.min(take, notTake);
            }
        }

        int ans = dp[n - 1][amount];

        if (ans >= INF)  return -1;

        return ans;
    }
}

// memoisation approach
// int solve(int index, int amount, int[] coins, int[][] dp) {

//     if (index == 0) {
//         if (amount % coins[0] == 0)
//             return amount / coins[0];
//         return (int) 1e9;
//     }

//     if (dp[index][amount] != -1)
//         return dp[index][amount];

//     int notTake = solve(index - 1, amount, coins, dp);

//     int take = (int) 1e9;
//     if (coins[index] <= amount) {
//         take = 1 + solve(index, amount - coins[index], coins, dp);
//     }

//     return dp[index][amount] = Math.min(take, notTake);
// }