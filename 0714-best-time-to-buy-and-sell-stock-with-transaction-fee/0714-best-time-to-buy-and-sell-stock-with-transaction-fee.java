class Solution {
    // Space optimization with 2 arrays
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;

        int[] ahead = new int[2]; // dp[i+1]
        int[] curr = new int[2];  // dp[i]

        for (int i = n - 1; i >= 0; i--) {

            // BUY state
            int buy = -prices[i] + ahead[0]; // perform buy
            int skipBuy = ahead[1];          // skip buying
            curr[1] = Math.max(buy, skipBuy);

            // SELL state
            int sell = prices[i] - fee + ahead[1]; // perform sell (fee applied)
            int skipSell = ahead[0];               // skip selling
            curr[0] = Math.max(sell, skipSell);

            // move current to ahead
            ahead = curr;
        }

        return ahead[1]; // start from buy state
    }
}