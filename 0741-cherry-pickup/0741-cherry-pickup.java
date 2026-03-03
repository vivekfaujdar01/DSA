class Solution {
    // Top-Down DP (Memoization)
    // c2 + r2 = r1 + c1 = k steps
    // c2 = r1 + c1 - r2 
    int n;
    Integer[][][] dp;

    public int cherryPickup(int[][] grid) {
        n = grid.length;
        dp = new Integer[n][n][n];

        int result = dfs(grid, 0, 0, 0);
        return Math.max(0, result);   // if no valid path
    }

    private int dfs(int[][] grid, int r1, int c1, int r2) {

        int c2 = r1 + c1 - r2;

        // Out of bounds
        if (r1 >= n || c1 >= n || r2 >= n || c2 >= n)
            return Integer.MIN_VALUE;

        // Thorn
        if (grid[r1][c1] == -1 || grid[r2][c2] == -1)
            return Integer.MIN_VALUE;

        // Reached end
        if (r1 == n - 1 && c1 == n - 1)
            return grid[r1][c1];

        // Already computed
        if (dp[r1][c1][r2] != null)
            return dp[r1][c1][r2];

        int cherries = 0;

        // If both at same cell → count once
        if (r1 == r2 && c1 == c2)
            cherries += grid[r1][c1];
        else
            cherries += grid[r1][c1] + grid[r2][c2];

        // 4 possible move combinations
        int downDown = dfs(grid, r1 + 1, c1, r2 + 1);
        int rightRight = dfs(grid, r1, c1 + 1, r2);
        int downRight = dfs(grid, r1 + 1, c1, r2);
        int rightDown = dfs(grid, r1, c1 + 1, r2 + 1);

        int bestNext = Math.max(Math.max(downDown, rightRight), Math.max(downRight, rightDown));
        dp[r1][c1][r2] = cherries + bestNext;
        return dp[r1][c1][r2];
    }
}