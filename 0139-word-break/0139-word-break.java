class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        int[] dp = new int[n]; 
        for(int i=0;i<n;i++){
            dp[i] = -1;
        }

        return rec(0, s, new HashSet<>(wordDict), dp);
    }

    public boolean rec(int i, String s, HashSet<String> set, int[] dp) {
        if (i == s.length()) return true;

        if (dp[i] != -1) return dp[i] == 1;

        for (int j = i; j < s.length(); j++) {
            String sub = s.substring(i, j + 1);

            if (set.contains(sub) && rec(j + 1, s, set, dp)) {
                dp[i] = 1;
                return true;
            }
        }

        dp[i] = 0;
        return false;
    }
}