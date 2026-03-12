class Solution {
    // tabulation (bottom-up)
    // We shift indices by 1 so we don't deal with negative indexes and dp will be dp[n+1][m+1]
    // So after shifting base case will become like if (j == 0)  return 1; and if (i == 0)  return 0;
    public int numDistinct(String s, String t) {

        int n = s.length();
        int m = t.length();

        int[][] dp = new int[n+1][m+1];

        // empty target
        for(int i = 0; i <= n; i++){
            dp[i][0] = 1;
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){

                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][m];
    }
}

// MEMOISATION 
// public int numDistinct(String s, String t) {

//     int n = s.length();
//     int m = t.length();

//     int[][] dp = new int[n][m];

//     for (int i = 0; i < n; i++) {
//         for (int j = 0; j < m; j++) {
//             dp[i][j] = -1;
//         }
//     }

//     return solve(n - 1, m - 1, s, t, dp);
// }

// int solve(int i, int j, String s, String t, int[][] dp) {

//     if (j < 0)  return 1;

//     if (i < 0)  return 0;

//     if (dp[i][j] != -1)  return dp[i][j];

//     if (s.charAt(i) == t.charAt(j)) {
//         dp[i][j] = solve(i - 1, j - 1, s, t, dp) + solve(i - 1, j, s, t, dp);
//     } else {
//         dp[i][j] = solve(i - 1, j, s, t, dp);
//     }

//     return dp[i][j];
// }