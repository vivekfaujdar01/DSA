class Solution {

    public int coinChange(int[] coins, int amount) {

        int n = coins.length;
        int INF = (int)1e9;

        int[] prev = new int[amount + 1];

        // Base case
        for (int a = 0; a <= amount; a++) {
            if (a % coins[0] == 0){
                prev[a] = a / coins[0];
            }
            else{
                prev[a] = INF;
            }
        }

        for (int i = 1; i < n; i++) {

            int[] curr = new int[amount + 1];

            for (int a = 0; a <= amount; a++) {

                int notTake = prev[a];

                int take = INF;
                if (coins[i] <= a) {
                    take = 1 + curr[a - coins[i]];
                }

                curr[a] = Math.min(take, notTake);
            }

            prev = curr;
        }

        int ans = prev[amount];

        if (ans >= INF)  return -1;

        return ans;
    }
}