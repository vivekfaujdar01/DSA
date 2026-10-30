class Solution {

    public int numTilePossibilities(String tiles) {

        // Build frequency array
        int[] freq = new int[26];

        for (char ch : tiles.toCharArray()) {
            freq[ch - 'A']++;
        }

        return backtrack(freq);
    }

    private int backtrack(int[] freq) {

        int count = 0;

        // Try all possible characters
        for (int i = 0; i < 26; i++) {

            // Character is not available
            if (freq[i] == 0) {
                continue;
            }

            freq[i]--;  // Choose

            count++; // Count the current non-empty sequence

            // Explore further sequences
            count += backtrack(freq);

            freq[i]++; // Backtrack: restore frequency
        }

        return count;
    }
}
