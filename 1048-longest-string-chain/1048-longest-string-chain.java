class Solution {
    // This is having similar logic to Longest Increasing Subsequence and
    // 368. Largest Divisible Subset
    public int longestStrChain(String[] words) {
        int n = words.length;  

        Arrays.sort(words, (a, b) -> a.length() - b.length()); // Sort by length (important like LIS order)

        int[] dp = new int[n];

        for(int i = 0 ; i < n ; i++){
            dp[i] = 1;
        }

        int maxi = 1;

        // LIS style loops
        for (int i = 0; i < n; i++) {
            for (int prev = 0; prev < i; prev++) {

                if (checkPossible(words[i], words[prev]) && dp[prev] + 1 > dp[i]) {
                    dp[i] = dp[prev] + 1;
                }
            }
            maxi = Math.max(maxi, dp[i]);
        }

        return maxi;
    }

    // it will check one character  difference in string

    public static boolean checkPossible(String s1, String s2) { 
        if (s1.length() != s2.length() + 1) return false;

        int i = 0, j = 0;

        while (i < s1.length()) {
            if (j < s2.length() && s1.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            } else {
                i++; // skip one char in s1
            }
        }

        return i == s1.length() && j == s2.length();
    }
}