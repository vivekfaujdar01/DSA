class Solution {
    // this question is totally depend on lcs
    // we find longest common subsequence in both words then find minimum deletions in each word and return addition of both minimum deletions of each.
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int deletionsfromword1 = n - longestCommonSubsequence(word1, word2);
        int deletionsfromword2 = m - longestCommonSubsequence(word1, word2); // we can call it as minimum insertions also 
        return deletionsfromword1 + deletionsfromword2; // (n+m-2lcs)
    }

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
