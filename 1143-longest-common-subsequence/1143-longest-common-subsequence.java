class Solution {
    // Space Optimization
    public int longestCommonSubsequence(String text1, String text2) {

        int n = text1.length();
        int m = text2.length();

        int[] prev = new int[m];

        for (int i = 0; i < n; i++) {
            int[] curr = new int[m];

            for (int j = 0; j < m; j++) {

                if (text1.charAt(i) == text2.charAt(j)) {
                    curr[j] = 1;
                    if (i > 0 && j > 0) {
                        curr[j] += prev[j - 1];
                    }
                } else {
                    int a = 0;
                    int b = 0;
                    if (i > 0) {
                        a = prev[j];
                    }
                    if (j > 0) {
                        b = curr[j - 1];
                    }
                    curr[j] = Math.max(a, b);
                }

            }

            prev = curr;
        }

        return prev[m - 1];
    }
}

//  Tabulation

// public int longestCommonSubsequence(String text1, String text2) {

//     int n = text1.length();
//     int m = text2.length();

//     int[][] dp = new int[n][m];

//     for (int i = 0; i < n; i++) {
//         for (int j = 0; j < m; j++) {

//             if (text1.charAt(i) == text2.charAt(j)) {
//                 dp[i][j] = 1;
//                 if (i > 0 && j > 0) {
//                     dp[i][j] += dp[i - 1][j - 1];
//                 }
//             } else {
//                 int a = 0;
//                 int b = 0;
//                 if (i > 0) {
//                     a = dp[i - 1][j];
//                 }
//                 if (j > 0) {
//                     b = dp[i][j - 1];
//                 }
//                 dp[i][j] = Math.max(a, b);
//             }

//         }
//     }

//     return dp[n - 1][m - 1];
// }