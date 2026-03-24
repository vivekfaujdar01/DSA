class Solution {
    // TABULATION method to solve it
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;

        int[][] dp = new int[n + 1][2];

        // dp[n][0] = dp[n][1] = 0

        for (int i = n - 1; i >= 0; i--) {

            // BUY state
            int buy = -prices[i] + dp[i + 1][0];
            int skipBuy = dp[i + 1][1];
            dp[i][1] = Math.max(buy, skipBuy);

            // SELL state
            int sell = prices[i] - fee + dp[i + 1][1]; // subtracting fee while selling
            int skipSell = dp[i + 1][0];
            dp[i][0] = Math.max(sell, skipSell);
        }

        return dp[0][1]; // start with buy allowed
    }
}

// MEMOIZATION
// int solve(int i, int buy, int[] prices, int fee, int[][] dp) {
//     if (i == prices.length)
//         return 0;
   
//     if (dp[i][buy] != -1){   // already computed
//         return dp[i][buy];
//     }
        
//     int profit;

//     if (buy == 1) {
//         int take = -prices[i] + solve(i + 1, 0, prices, fee, dp);
//         int skip = solve(i + 1, 1, prices, fee, dp);
//         profit = Math.max(take, skip);
//     } else {
//         int take = prices[i] - fee + solve(i + 1, 1, prices, fee, dp);
//         int skip = solve(i + 1, 0, prices, fee, dp);
//         profit = Math.max(take, skip);
//     }

//     return dp[i][buy] = profit; // store result
// }