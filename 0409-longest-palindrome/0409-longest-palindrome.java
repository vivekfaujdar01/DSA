class Solution {
    public int longestPalindrome(String s) {
        int[] freq = new int[128]; // ASCII

        for (char ch : s.toCharArray()) { // Count frequency
            freq[ch]++;
        }

        int length = 0;
        boolean hasOdd = false;

        for (int f : freq) {
            if (f % 2 == 0) {
                length += f;
            } else {
                length += f - 1; // take even part
                hasOdd = true;
            }
        }

        // Add center if needed
        if (hasOdd){
            length++;
        } 

        return length;
    }
}