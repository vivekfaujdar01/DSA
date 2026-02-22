class Solution {
    // memoisation approach
    public int rec(int i, int j, int[][] dp, int[][] grid){
        if(i==0 && j==0){
            return grid[i][j];
        }
        if(i<0 || j<0){
            return (int)1e9;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int up = grid[i][j] + rec(i-1, j, dp, grid);
        int left = grid[i][j] + rec(i, j-1, dp, grid);

        dp[i][j] = Math.min(up, left);
        
        return dp[i][j];
    }
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return rec(n-1, m-1, dp, grid);
    }
}