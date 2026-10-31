// Time Complexity - O(n^2)
class Solution {
    public int longestSubstring(String s, int k) {

        int n = s.length();
        int ans = 0;

        for (int i = 0; i < n; i++) {

            int[] freq = new int[26];

            for (int j = i; j < n; j++) {

                // Add only the newly included character
                freq[s.charAt(j) - 'a']++;

                // Check validity
                boolean valid = true;

                for (int count : freq) {
                    if (count > 0 && count < k) {
                        valid = false;
                        break;
                    }
                }

                if (valid) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }

        return ans;
    }
}
