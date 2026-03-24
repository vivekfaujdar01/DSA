class Solution {
    // Tabulation(Bottom-Up)
    // DP of size: dp[n+2][2] because we need access to i+2

    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[][] dp = new int[n + 2][2];

        for (int i = n - 1; i >= 0; i--) {

            // canBuy = 1 Or Buy
            int buy = -prices[i] + dp[i + 1][0];
            int skipBuy = dp[i + 1][1];
            dp[i][1] = Math.max(buy, skipBuy);

            // dp[i][1] = Math.max(-prices[i] + dp[i + 1][0], dp[i + 1][1]);

            // canBuy = 0 Or Sell
            int sell = prices[i] + dp[i + 2][1]; // cooldown
            int skipSell = dp[i + 1][0];
            dp[i][0] = Math.max(sell, skipSell);

            // dp[i][0] = Math.max(prices[i] + dp[i + 2][1], dp[i + 1][0]);
        }

        return dp[0][1]; // start from day 0 with buy allowed
    }

}

// MEMOIZATION(Top-Down)
// public int maxProfit(int[] prices) {
//     int n = prices.length;
//     int[][] dp = new int[n][2];

//     for (int i = 0; i < n; i++) {
//         dp[i][0] = dp[i][1] = -1;
//     }

//     return helper(0, 1, prices, dp);
// }

// private int helper(int i, int canBuy, int[] prices, int[][] dp) {
//     if (i >= prices.length)
//         return 0;

//     // if already computed
//     if (dp[i][canBuy] != -1){
//         return dp[i][canBuy];
//     }

//     int profit;

//     if (canBuy == 1) {
//         int buy = -prices[i] + helper(i + 1, 0, prices, dp);
//         int skip = helper(i + 1, 1, prices, dp);
//         profit = Math.max(buy, skip);
//     } else {
//         int sell = prices[i] + helper(i + 2, 1, prices, dp); // cooldown
//         int skip = helper(i + 1, 0, prices, dp);
//         profit = Math.max(sell, skip);
//     }

//     return dp[i][canBuy] = profit;
// }