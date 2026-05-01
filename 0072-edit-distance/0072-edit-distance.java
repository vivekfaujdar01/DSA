class Solution {
    // 1 index shifting
    public int minDistance(String s1, String s2) {
        int n = s1.length(), m = s2.length();

        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                dp[i][j] = -1;
            }
        }

        return rec(n, m, s1, s2, dp);
    }

    public int rec(int i, int j, String s1, String s2, int[][] dp) {
        if (i == 0) return j;
        if (j == 0) return i;

        if (dp[i][j] != -1) return dp[i][j];

        if (s1.charAt(i-1) == s2.charAt(j-1)) {
            return dp[i][j] = rec(i - 1, j - 1, s1, s2, dp);
        }

        int insert = rec(i, j - 1, s1, s2, dp);
        int delete = rec(i - 1, j, s1, s2, dp);
        int replace = rec(i - 1, j - 1, s1, s2, dp);

        return dp[i][j] = 1 + Math.min(insert, Math.min(delete, replace));
    }
}