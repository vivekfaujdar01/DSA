class Solution {
    int m, n;
    int MOD = 1000000007;
    Integer[][][] dp; // 3D DP array for memoization

    public int numberOfPaths(int[][] grid, int k) {
        m = grid.length;
        n = grid[0].length;
        // dp[row][col][remainder]
        dp = new Integer[m][n][k];

        return dfs(grid, 0, 0, 0, k); // start recursion from (0,0) with remainder 0
    }

    private int dfs(int[][] grid, int i, int j, int rem, int k) {

        if (i >= m || j >= n)
            return 0;

        rem = (rem + grid[i][j]) % k;

        if (i == m - 1 && j == n - 1) {

            // If final remainder is 0
            // path sum is divisible by k
            if (rem == 0)
                return 1;

            return 0;
        }

        if (dp[i][j][rem] != null)
            return dp[i][j][rem];
     
        int right = dfs(grid, i, j + 1, rem, k);  // move right

        int down = dfs(grid, i + 1, j, rem, k); // move down

        dp[i][j][rem] = (right + down) % MOD; // store result in DP table

        return dp[i][j][rem];
    }
}