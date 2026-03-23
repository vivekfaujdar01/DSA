class Solution {
    // 123. Best Time to Buy and Sell Stock III
    // just copy pasted the code of that changes capacity of array to k+1
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;

        int[][] after = new int[2][k+1];
        int[][] curr = new int[2][k+1];

        for (int index = n - 1; index >= 0; index--) {

            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 1; cap <= k; cap++) {

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

        return after[1][k];
    }
}