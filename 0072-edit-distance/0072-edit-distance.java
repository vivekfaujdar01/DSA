class Solution {
    // tabulation(bottom-up) to solve it
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n+1][m+1];

        // base cases
        for(int i = 0; i <= n; i++){
            dp[i][0] = i;
        }  

        for(int j = 0; j <= m; j++){
            dp[0][j] = j;
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){

                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    int insert = dp[i][j-1];
                    int delete = dp[i-1][j];
                    int replace = dp[i-1][j-1];

                    dp[i][j] = 1 + Math.min(insert, Math.min(delete, replace));
                }
            }
        }
        return dp[n][m];
    }
}

// Memoisation with 1 based indexing 
// int solve(String s1, String s2, int i, int j, int[][] dp) {

//     // base cases
//     if (i == 0){
//         return j;
//     }
        
//     if (j == 0){
//         return i;
//     }
       
//     if (dp[i][j] != -1){
//         return dp[i][j];
//     }
        
//     if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
//         return dp[i][j] = solve(s1, s2, i - 1, j - 1, dp);
//     }

//     int insert = 1 + solve(s1, s2, i, j - 1, dp);
//     int delete = 1 + solve(s1, s2, i - 1, j, dp);
//     int replace = 1 + solve(s1, s2, i - 1, j - 1, dp);

//     return dp[i][j] = Math.min(insert, Math.min(delete, replace));
// }