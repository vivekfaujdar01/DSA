class Solution {
    // tabulation approach
    // because matrix cannot handle negative index so we have to shift 1 index so in this we make dp[n+1][m+1]
    // that's why in memoisation base case will become if (i == 0 || j == 0) return 0;
    // so according to memoisation base case tabulation will become like
    public int longestCommonSubsequence(String text1, String text2) {

        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n+1][m+1];
        
        for(int i = 0; i < m+1; i++){
            dp[0][i] = 0;
        }

        for(int i = 0; i < n+1; i++){
            dp[i][0] = 0;
        }
        for(int i = 1; i < n+1; i++) {
            for(int j = 1; j < m+1; j++) {

                if(text1.charAt(i-1) == text2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];

                else
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }

        return dp[n][m];
    }
}

// MEMOISATION
// public int longestCommonSubsequence(String text1, String text2) {

//     int n = text1.length();
//     int m = text2.length();

//     int[][] dp = new int[n][m];

//     for (int[] row : dp)
//         Arrays.fill(row, -1);

//     return solve(n - 1, m - 1, text1, text2, dp);
// }

// int solve(int i, int j, String s1, String s2, int[][] dp) {

//     if (i < 0 || j < 0)
//         return 0;

//     if (dp[i][j] != -1)
//         return dp[i][j];

//     if (s1.charAt(i) == s2.charAt(j))
//         return dp[i][j] = 1 + solve(i - 1, j - 1, s1, s2, dp);

//     return dp[i][j] = Math.max(
//             solve(i - 1, j, s1, s2, dp),
//             solve(i, j - 1, s1, s2, dp));
// }