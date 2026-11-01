// Time complexity: O(26n) Sliding Window 
// left = 	Starting index of the current window
// unique =	Number of distinct characters in the window
// countAtLeastK = Number of distinct characters whose frequency is at least k
// freq[] = Frequency of each character in the current window
class Solution {

    public int longestSubstring(String s, int k) {

        int n = s.length();
        int ans = 0;

        // Try every possible number of distinct characters
        for (int targetUnique = 1; targetUnique <= 26; targetUnique++) {

            int[] freq = new int[26];

            int left = 0;
            int unique = 0;
            int countAtLeastK = 0;

            // Expand the window
            for (int right = 0; right < n; right++) {

                int index = s.charAt(right) - 'a';

                // New distinct character
                if (freq[index] == 0) {
                    unique++;
                }

                // Include the current character
                freq[index]++;

                // Character has reached frequency k
                if (freq[index] == k) {
                    countAtLeastK++;
                }

                // Shrink while distinct characters exceed target
                while (unique > targetUnique) {

                    int leftIndex = s.charAt(left) - 'a';

                    // Character will fall below frequency k
                    if (freq[leftIndex] == k) {
                        countAtLeastK--;
                    }

                    freq[leftIndex]--;

                    // Character completely removed
                    if (freq[leftIndex] == 0) {
                        unique--;
                    }

                    left++;
                }

                // Check whether current window is valid
                if (unique == targetUnique &&
                        countAtLeastK == targetUnique) {

                    ans = Math.max(ans, right - left + 1);
                }
            }
        }

        return ans;
    }
}

// Divide and Conquer (Recursive)
// Time complexity: O(26n) there are only 26 distinct characters, the maximum recursion depth is bounded by 26.
// class Solution {

//     public int longestSubstring(String s, int k) {
//         return solve(s, 0, s.length() - 1, k);
//     }

//     private int solve(String s, int start, int end, int k) {

//         // Base case
//         if (end - start + 1 < k) {
//             return 0;
//         }

//         int[] freq = new int[26];

//         for (int i = start; i <= end; i++) {
//             freq[s.charAt(i) - 'a']++;
//         }

//         // Find an invalid character
//         for (int i = start; i <= end; i++) {

//             char ch = s.charAt(i);

//             if (freq[ch - 'a'] < k) {

//                 int maxLength = 0;
//                 int segmentStart = start;

//                 // Split around all occurrences of this invalid character
//                 for (int j = start; j <= end; j++) {

//                     if (s.charAt(j) == ch) {
//                         maxLength = Math.max(maxLength, solve(s, segmentStart, j - 1, k));
//                         segmentStart = j + 1;
//                     }
//                 }

//                 // Process the remaining segment
//                 maxLength = Math.max(maxLength, solve(s, segmentStart, end, k));

//                 return maxLength;
//             }
//         }

//         // No invalid character: entire substring is valid
//         return end - start + 1;
//     }
// }

// // Time Complexity - O(n^2)
// class Solution {
//     public int longestSubstring(String s, int k) {

//         int n = s.length();
//         int ans = 0;

//         for (int i = 0; i < n; i++) {

//             int[] freq = new int[26];

//             for (int j = i; j < n; j++) {

//                 // Add only the newly included character
//                 freq[s.charAt(j) - 'a']++;

//                 // Check validity
//                 boolean valid = true;

//                 for (int count : freq) {
//                     if (count > 0 && count < k) {
//                         valid = false;
//                         break;
//                     }
//                 }

//                 if (valid) {
//                     ans = Math.max(ans, j - i + 1);
//                 }
//             }
//         }

//         return ans;
//     }
// }
