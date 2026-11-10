// Space Optimization
class Solution {

    public int climbStairs(int n, int[] costs) {

        int prev3 = 0;
        int prev2 = 0;
        int prev1 = 0;

        for (int i = 1; i <= n; i++) {

            int minCost = prev1 + 1;

            if (i >= 2) {
                minCost = Math.min(minCost, prev2 + 4);
            }

            if (i >= 3) {
                minCost = Math.min(minCost, prev3 + 9);
            }

            int current = costs[i - 1] + minCost;

            // Shift previous states
            prev3 = prev2;
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}


// // Bottom-Up Tabulation (Iterative DP)
// class Solution {

//     public int climbStairs(int n, int[] costs) {

//         int[] dp = new int[n + 1];

//         dp[0] = 0;

//         // Calculate minimum cost for every step
//         for (int i = 1; i <= n; i++) {

//             int minCost = dp[i - 1] + 1;

//             if (i >= 2) {
//                 minCost = Math.min(minCost, dp[i - 2] + 4);
//             }

//             if (i >= 3) {
//                 minCost = Math.min(minCost, dp[i - 3] + 9);
//             }

//             dp[i] = costs[i - 1] + minCost;
//         }

//         return dp[n];
//     }
// }
