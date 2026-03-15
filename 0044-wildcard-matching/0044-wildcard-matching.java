class Solution {
    // tabulation method and memoisation is commented below 
    public boolean isMatch(String s, String p) {

        int n = s.length();
        int m = p.length();

        boolean[][] dp = new boolean[n + 1][m + 1];

        dp[0][0] = true;

        // dp[i][0] = false automatically

        for (int j = 1; j <= m; j++) {

            boolean flag = true;
            
            for (int k = 1; k <= j; k++) {
                if (p.charAt(k - 1) != '*') {
                    flag = false;
                    break;
                }
            }

            dp[0][j] = flag;
        }

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= m; j++) {

                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);

                if (sc == pc || pc == '?'){
                    dp[i][j] = dp[i - 1][j - 1];
                }

                else if (pc == '*'){
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }

                else{
                    dp[i][j] = false;
                }                  
            }
        }

        return dp[n][m];
    }
}

// MEMOISATION
// boolean solve(int i, int j, String s, String p) {

//     if (i == 0 && j == 0)   return true;

//     if (j == 0 && i > 0)    return false;

//     if (i == 0 && j > 0) {
//         for (int k = 1; k <= j; k++) {
//             if (p.charAt(k - 1) != '*')
//                 return false;
//         }
//         return true;
//     }

//     if (dp[i][j] != null)    return dp[i][j];

//     if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?'){
//         return dp[i][j] = solve(i - 1, j - 1, s, p);
//     }

//     if (p.charAt(j - 1) == '*'){
//         return dp[i][j] = solve(i, j - 1, s, p) || solve(i - 1, j, s, p);
//     }
        
//     return dp[i][j] = false;
// }