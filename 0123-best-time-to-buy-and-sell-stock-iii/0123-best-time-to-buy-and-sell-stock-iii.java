class Solution {
    // Tabulation method
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[][][] dp = new int[n + 1][2][3]; // we use n+1 because we need extra row for index+1

        for (int index = n - 1; index >= 0; index--) { // starting from n-1
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 1; cap <= 2; cap++) {

                    if (buy == 1) {
                        int take = -prices[index] + dp[index + 1][0][cap];
                        int skip = dp[index + 1][1][cap];

                        dp[index][1][cap] = Math.max(take, skip);
                    } else {
                        int take = prices[index] + dp[index + 1][1][cap - 1];
                        int skip = dp[index + 1][0][cap];

                        dp[index][0][cap] = Math.max(take, skip);
                    }
                }
            }
        }

        return dp[0][1][2];
    }
}

// MEMOIZATION
// int[][][] dp = new int[n][2][3];
// private int helper(int[] prices, int index, int buy, int cap, int[][][] dp) {
//     // Base case
//     if (index == prices.length || cap == 0) return 0;
//     // Memo check
//     if (dp[index][buy][cap] != -1)
//         return dp[index][buy][cap];
//     int profit;
//     if (buy == 1) {
//         int take = -prices[index] + helper(prices, index + 1, 0, cap, dp);
//         int skip = helper(prices, index + 1, 1, cap, dp);
//         profit = Math.max(take, skip);
//     } else {
//         int sell = prices[index] + helper(prices, index + 1, 1, cap - 1, dp);
//         int skip = helper(prices, index + 1, 0, cap, dp);
//         profit = Math.max(sell, skip);
//     }
//     return dp[index][buy][cap] = profit;
// }