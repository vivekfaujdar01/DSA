class Solution {
    public int maximalSquare(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int[] next = new int[m + 1]; 
        int maxi = 0;

        for(int i = n - 1; i >= 0; i--){
            int[] curr = new int[m + 1]; 

            for(int j = m - 1; j >= 0; j--){
                if(matrix[i][j] == '1'){
                    curr[j] = 1 + Math.min(next[j], Math.min(curr[j+1], next[j+1]));
                    maxi = Math.max(maxi, curr[j]);
                }
            }

            next = curr; 
        }

        return maxi * maxi;
    }
}

// class Solution {
//     // tabulation(bottom-up)
//     public int maximalSquare(char[][] matrix) {
//         int n = matrix.length;
//         int m = matrix[0].length;

//         int[][] dp = new int[n + 1][m + 1];
//         int maxi = 0;

//         for(int i = n - 1; i >= 0; i--){
//             for(int j = m - 1; j >= 0; j--){
//                 if(matrix[i][j] == '1'){
//                     dp[i][j] = 1 + Math.min(dp[i+1][j], Math.min(dp[i][j+1], dp[i+1][j+1]));

//                     maxi = Math.max(maxi, dp[i][j]);
//                 }
//             }
//         }

//         return maxi * maxi;
//     }
// }
