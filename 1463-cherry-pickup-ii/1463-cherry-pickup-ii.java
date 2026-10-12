class Solution {
    // memoization(Top-Down)
    public int cherryPickup(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][][] dp = new int[rows][cols][cols];

        // Mark every state as uncomputed
        for (int i = 0; i < rows; i++) {
            for (int j1 = 0; j1 < cols; j1++) {
                for (int j2 = 0; j2 < cols; j2++) {
                    dp[i][j1][j2] = -1;
                }
            }
        }

        return solve(0, 0, cols - 1, grid, dp);
    }

    private int solve(int i, int j1, int j2, int[][] grid, int[][][] dp) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Boundary case
        if (j1 < 0 || j1 >= cols || j2 < 0 || j2 >= cols) {
            return 0;
        }

        // Base case: last row
        if (i == rows - 1) {
            if (j1 == j2) {
                return grid[i][j1];
            }

            return grid[i][j1] + grid[i][j2];
        }

        if (dp[i][j1][j2] != -1) {
            return dp[i][j1][j2];
        } 

        // Cherries collected in the current row
        int cherries;

        if (j1 == j2) {
            cherries = grid[i][j1];
        } else {
            cherries = grid[i][j1] + grid[i][j2];
        }

        int maxCherries = 0;

        // Explore all 9 combinations
        for (int dj1 = -1; dj1 <= 1; dj1++) {
            for (int dj2 = -1; dj2 <= 1; dj2++) {

                int next = solve(i + 1, j1 + dj1, j2 + dj2, grid, dp);

                maxCherries = Math.max(maxCherries, next);
            }
        }

        return dp[i][j1][j2] = cherries + maxCherries;
    }
}
