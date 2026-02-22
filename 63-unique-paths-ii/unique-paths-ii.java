class Solution {
    // Memoization approach 
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(m - 1, n - 1, obstacleGrid, dp);
        
    }

    private int solve(int i, int j, int[][] grid, int [][] dp) {
        // Out of bounds
        if (i < 0 || j < 0) return 0;
        // Obstacle
        if (grid[i][j] == 1) return 0;
        // Reached source
        if (i == 0 && j == 0) return 1;

        if (dp[i][j] != -1)  return dp[i][j];

        int up = solve(i - 1, j, grid, dp);
        int left = solve(i, j - 1, grid, dp);

        dp[i][j] = up + left;
        return dp[i][j];
    }
}