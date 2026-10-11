class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[] prev = new int[m];

        for (int i = 0; i < n; i++) {
            int[] curr = new int[m];

            for (int j = 0; j < m; j++) {

                if (i == 0 && j == 0) {
                    curr[j] = grid[i][j];
                } else {
                    int up = (i > 0) ? prev[j] : (int) 1e5;
                    int left = (j > 0) ? curr[j - 1] : (int) 1e5;

                    curr[j] = grid[i][j] + Math.min(up, left);
                }
            }

            prev = curr; // move current row to previous
        }

        return prev[m - 1];
    }
}

//Tabulation

// class Solution {
//     public int minPathSum(int[][] grid) {
//         int m = grid.length;
//         int n = grid[0].length;

//         int[][] dp = new int[m][n];

//         dp[0][0] = grid[0][0];

//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {

//                 if (i == 0 && j == 0) continue;

//                 int up = (i > 0) ? dp[i - 1][j] : (int)1e5;
//                 int left = (j > 0) ? dp[i][j - 1] : (int)1e5;

//                 dp[i][j] = grid[i][j] + Math.min(up, left);
//             }
//         }

//         return dp[m - 1][n - 1];
//     }
// }