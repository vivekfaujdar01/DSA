class Solution {
    // Improved Brute Force
    public int numberOfSubstrings(String s, int k) {

        int n = s.length();
        int ans = 0;

        for (int i = 0; i < n; i++) {

            int[] freq = new int[26];

            for (int j = i; j < n; j++) {

                char ch = s.charAt(j);
                freq[ch - 'a']++;

                if (freq[ch - 'a'] >= k) {

                    ans += n - j;
                    break;
                }
            }
        }

        return ans;
    }
}