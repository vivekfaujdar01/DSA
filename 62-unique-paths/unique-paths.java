class Solution {
    // Memoization approach 
    // we started from finish point then go to starting point
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        return solve(m - 1, n - 1, dp);
    }

    private int solve(int i, int j, int[][] dp) {
        // Reached source
        if (i == 0 && j == 0) return 1;
        // Out of bounds
        if (i < 0 || j < 0) return 0;

        if (dp[i][j] != 0) return dp[i][j];

        int up = solve(i - 1, j, dp);
        int left = solve(i, j - 1, dp);

        dp[i][j] = up + left;
        return dp[i][j];
    }
}
    // tabulation approach
    // public int uniquePaths(int m, int n){
    //     int dp[m][n];
    //     for(int i = 0; i < m; i++){
    //         for(int j = 0; j < n; j++){
    //             if(i == 0 && j == 0)    dp[i][j] = 1;
    //             else{
    //                 int up = 0;
    //                 int left = 0;
    //                 if(i > 0)   up = dp[i-1][j];
    //                 if(j > 0)   left = dp[i][j-1];
    //                 dp[i][j] = up + left;
    //             }
    //         }
    //     }
    //     return dp[m-1][n-1];
    // }

    // recursive approach 
    // public int uniquePaths(int m, int n) {
    //     return solve(m - 1, n - 1);
    // }

    // private int solve(int i, int j) {
    //     // Reached source
    //     if (i == 0 && j == 0) return 1;

    //     // Out of bounds
    //     if (i < 0 || j < 0) return 0;

    //     int up = solve(i - 1, j);
    //     int left = solve(i, j - 1);

    //     return up + left;
    // }