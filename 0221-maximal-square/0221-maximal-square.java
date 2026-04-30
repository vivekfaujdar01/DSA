class Solution {

    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[][] dp = new int[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                dp[i][j] = -1;
            }
        }
        
        int maxi = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                maxi = Math.max(maxi, f(i, j, matrix, dp));
            }
        }

        return maxi * maxi;
    }

    public int f(int i, int j, char[][] matrix, int[][] dp){
        int n = matrix.length;
        int m = matrix[0].length;

        if(i >= n || j >= m) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        if(matrix[i][j] == '0'){
            return dp[i][j] = 0;
        }

        int down = f(i + 1, j, matrix, dp);
        int right = f(i, j + 1, matrix, dp);
        int diag = f(i + 1, j + 1, matrix, dp);

        return dp[i][j] = 1 + Math.min(down, Math.min(right, diag));
    }
}