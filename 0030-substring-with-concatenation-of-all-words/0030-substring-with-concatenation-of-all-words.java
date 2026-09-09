// 1. Count required words.
// 2. Try every possible offset from 0 to wordLen-1.
// 3. Use left/right pointers moving by wordLen.
// 4. If word is not required → reset window.
// 5. If word occurs too many times → shrink from left.
// 6. If window contains exactly words.length words → answer.
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> ans = new ArrayList<>();

        int wordLen = words[0].length();
        int wordCount = words.length;
        int totalLen = wordLen * wordCount;

        // Required frequency of each word
        HashMap<String, Integer> required = new HashMap<>();

        for (String word : words) {
            required.put(word, required.getOrDefault(word, 0) + 1);
        }

        // Try every possible starting offset
        for (int offset = 0; offset < wordLen; offset++) {

            int left = offset;
            int right = offset;

            // Words currently inside the window
            HashMap<String, Integer> current = new HashMap<>();

            int count = 0; // number of words in current window

            while (right + wordLen <= s.length()) {

                // Take one word-sized chunk
                String word = s.substring(right, right + wordLen);
                right += wordLen;

                // Case 1: word is not required
                if (!required.containsKey(word)) {
                    current.clear();
                    count = 0;
                    left = right;
                    continue;
                }

                // Add word to current window
                current.put(word, current.getOrDefault(word, 0) + 1);
                count++;

                // Case 2: too many copies of this word
                while (current.get(word) > required.get(word)) {

                    String leftWord = s.substring(left, left + wordLen);

                    current.put(leftWord, current.get(leftWord) - 1);
                    count--;

                    left += wordLen;
                }

                // We have exactly all required words
                if (count == wordCount) {
                    ans.add(left);

                    // Move left forward to continue searching
                    String leftWord = s.substring(left, left + wordLen);

                    current.put(leftWord, current.get(leftWord) - 1);
                    count--;

                    left += wordLen;
                }
            }
        }

        return ans;
    }
}