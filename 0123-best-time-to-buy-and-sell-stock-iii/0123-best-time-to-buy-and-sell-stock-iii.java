class Solution {
    // Space optimisation using 2 arrays 
    // we put after at place of dp[index+1] and curr at dp[index] 
    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[][] after = new int[2][3];
        int[][] curr = new int[2][3];

        for (int index = n - 1; index >= 0; index--) {

            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 1; cap <= 2; cap++) {

                    if (buy == 1) {
                        int take = -prices[index] + after[0][cap];
                        int skip = after[1][cap];

                        curr[1][cap] = Math.max(take, skip);
                    } else {
                        int take = prices[index] + after[1][cap - 1];
                        int skip = after[0][cap];

                        curr[0][cap] = Math.max(take, skip);
                    }
                }
            }

            // Move curr -> after
            after = curr;
        }

        return after[1][2];
    }
}