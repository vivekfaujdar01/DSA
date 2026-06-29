class Solution {
    // Tabulation (shifting index by +1 of both because prev = -1 and we are accessing after last index of arr) 
    public int lengthOfLIS(int[] arr) {
        int n = arr.length;

        int[][] dp = new int[n + 1][n + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int prev = i - 1; prev >= -1; prev--) {

                int notTake = dp[i + 1][prev + 1];

                int take = 0;
                if (prev == -1 || arr[i] > arr[prev]) {
                    take = 1 + dp[i + 1][i + 1];
                }

                dp[i][prev + 1] = Math.max(take, notTake);
            }
        }

        return dp[0][0];
    }
}

// Memoization (shifting index by +1 because prev = -1)
// public int lengthOfLIS(int[] arr) {
//     int n = arr.length;
//     int[][] dp = new int[n][n + 1];

//     for (int[] row : dp) {
//         Arrays.fill(row, -1);
//     }

//     return solve(0, -1, arr, dp);
// }

// public int solve(int i, int prev, int[] arr, int[][] dp) {
//     if (i == arr.length)
//         return 0;

//     if (dp[i][prev + 1] != -1)
//         return dp[i][prev + 1];

//     int notTake = solve(i + 1, prev, arr, dp);

//     int take = 0;
//     if (prev == -1 || arr[i] > arr[prev]) {
//         take = 1 + solve(i + 1, i, arr, dp);
//     }

//     return dp[i][prev + 1] = Math.max(take, notTake);
// }

// recursive code

// public int lengthOfLIS(int[] arr) {
//     return solve(0, -1, arr);
// }

// public int solve(int i, int prev, int[] arr) {
//     if (i == arr.length)
//         return 0;

//     int notTake = solve(i + 1, prev, arr);

//     int take = 0;
//     if (prev == -1 || arr[i] > arr[prev]) {
//         take = 1 + solve(i + 1, i, arr);
//     }

//     return Math.max(take, notTake);
// }
