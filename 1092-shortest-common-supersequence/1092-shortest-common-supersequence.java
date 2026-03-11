class Solution {
    // for finding length of Shortest Common Supersequence the logic is like we are taking only one time common character from both we can think about lcs and then 
    // formula can be like (n-lcs(s)) + lcs(s) + (m-lcs(s)) = n+m-lcs(s);
    // and for printing the Shortest Common Supersequence we are backtracking in dp table of lcs
    // in this we are creating dp array and fill it and code for that is same as lcs
    // after dp filling we backtrack from last block of dp and find the shortest common supersequence
    public String shortestCommonSupersequence(String text1, String text2) {
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

        // Backtracking to build SCS
        int i = n;
        int j = m;

        StringBuilder ans = new StringBuilder();

        while (i > 0 && j > 0) {

            if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                ans.append(text1.charAt(i - 1));
                i--; j--;   
            }

            else if (dp[i - 1][j] > dp[i][j - 1]) {
                ans.append(text1.charAt(i - 1));
                i--;
            }

            else {
                ans.append(text2.charAt(j - 1));
                j--;
            }
        }

        // Remaining characters
        while (i > 0) {
            ans.append(text1.charAt(i - 1));
            i--;
        }

        while (j > 0) {
            ans.append(text2.charAt(j - 1));
            j--;
        }

        return ans.reverse().toString();
    }
}