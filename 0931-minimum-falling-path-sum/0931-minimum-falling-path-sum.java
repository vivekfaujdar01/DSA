class Solution {
    // Bottom-Up Tabulation
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];

        for (int col = 0; col < n; col++) {
            dp[0][col] = matrix[0][col];
        }

        for (int row = 1; row < n; row++) {
            for (int col = 0; col < n; col++) {

                int up = matrix[row][col] + dp[row - 1][col];
                
                int leftDiag = col > 0 ? matrix[row][col] + dp[row - 1][col - 1] : (int)1e9;
                int rightDiag = col < n - 1 ? matrix[row][col] + dp[row - 1][col + 1] : (int)1e9;

                dp[row][col] =  Math.min(up, Math.min(leftDiag, rightDiag));
            }
        }

        int ans = Integer.MAX_VALUE;
        for (int col = 0; col < n; col++) {
            ans = Math.min(ans, dp[n - 1][col]);
        }

        return ans;
    }
}
    // Recursive Code (Brute Force)
    // public int minFallingPathSum(int[][] matrix) {
    //     int n = matrix.length;
    //     int ans = Integer.MAX_VALUE;
    //     
    //     for (int col = 0; col < n; col++) {
    //         ans = Math.min(ans, dfs(matrix, n - 1, col));
    //     }
    //     
    //     return ans;
    // }

    // private int dfs(int[][] matrix, int row, int col) {
    //     if (col < 0 || col >= matrix.length)
    //         return (int)1e9;  // invalid path
    //     
    //     if (row == 0)
    //         return matrix[0][col];
    //     int upLeft = matrix[row][col] +  dfs(matrix, row - 1, col - 1);
    //     int up = matrix[row][col] +  dfs(matrix, row - 1, col);
    //     int upRight = matrix[row][col] +  dfs(matrix, row - 1, col + 1);
    //     return Math.min(up, Math.min(upLeft, upRight));
    // }