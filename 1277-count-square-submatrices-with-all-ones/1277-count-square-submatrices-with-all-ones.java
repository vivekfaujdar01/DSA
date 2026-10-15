class Solution {

    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];

        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                // Current cell is zero
                if (matrix[i][j] == 0) {
                    dp[i][j] = 0;
                }

                // First row or first column
                else if (i == 0 || j == 0) {
                    dp[i][j] = 1;
                }

                // Apply the recurrence
                else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
                }
                
                // Add the number of squares ending here
                count += dp[i][j];
            }
        }

        return count;
    }
}


// class Solution {

//     public int countSquares(int[][] matrix) {
//         int m = matrix.length;
//         int n = matrix[0].length;

//         int[][] dp = new int[m][n];

//         for (int[] row : dp) {
//             Arrays.fill(row, -1);
//         }

//         int count = 0;

//         for (int i = 0; i < m; i++) {
//             for (int j = 0; j < n; j++) {
//                 count += solve(i, j, matrix, dp);
//             }
//         }

//         return count;
//     }

//     private int solve(int i, int j, int[][] matrix, int[][] dp) {

//         // Base case: outside the matrix
//         if (i < 0 || j < 0) {
//             return 0;
//         }

//         if (dp[i][j] != -1) {
//             return dp[i][j];
//         }

//         // Current cell is zero
//         if (matrix[i][j] == 0) {
//             return dp[i][j] = 0;
//         }

//         int up = solve(i - 1, j, matrix, dp);
//         int left = solve(i, j - 1, matrix, dp);
//         int diagonal = solve(i - 1, j - 1, matrix, dp);

//         dp[i][j] = 1 + Math.min(up, Math.min(left, diagonal));

//         return dp[i][j];
//     }
// }
