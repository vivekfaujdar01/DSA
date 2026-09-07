class Solution {

    Boolean[][] dp;

    public String longestPalindrome(String s) {
        int n = s.length();
        dp = new Boolean[n][n];

        int start = 0;
        int maxLen = 1;

        // Try all substrings
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {

                if (isPalindrome(i, j, s)) {
                    int len = j - i + 1;

                    if (len > maxLen) {
                        maxLen = len;
                        start = i;
                    }
                }
            }
        }

        return s.substring(start, start + maxLen);
    }

    private boolean isPalindrome(int i, int j, String s) {

        // Base case
        if (i >= j) return true;

        // Already computed
        if (dp[i][j] != null) return dp[i][j];

        // If characters mismatch
        if (s.charAt(i) != s.charAt(j)) {
            return dp[i][j] = false;
        }

        // Check inner substring
        return dp[i][j] = isPalindrome(i + 1, j - 1, s);
    }
}