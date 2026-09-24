class Solution {
    public int characterReplacement(String s, int k) {

        int[] freq = new int[26];

        int left = 0;
        int maxFreq = 0;
        int ans = 0;

        for (int right = 0; right < s.length(); right++) {

            // Include current character in window
            char ch = s.charAt(right);
            freq[ch - 'A']++;

            // Update maximum frequency in current window
            maxFreq = Math.max(maxFreq, freq[ch - 'A']);

            // If replacements required > k, shrink window
            while ((right - left + 1) - maxFreq > k) {

                freq[s.charAt(left) - 'A']--;
                left++;

                maxFreq = 0;

                for (int i = 0; i < 26; i++) {
                    maxFreq = Math.max(maxFreq, freq[i]);
                }
            }

            // Update answer
            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}