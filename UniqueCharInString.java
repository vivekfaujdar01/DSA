// UniqueCharInString.java
// LeetCode Problem 387: First Unique Character in a String
// This code finds the first non-repeating character in a string and returns its index. 
public class UniqueCharInString {
// If no unique character exists, it returns -1.
    public int firstUniqChar(String s) {
        int[] charCount = new int[26]; // Assuming only lowercase English letters

        // Count the frequency of each character
        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }

        // Find the first unique character
        for (int i = 0; i < s.length(); i++) {
            if (charCount[s.charAt(i) - 'a'] == 1) {
                return i; // Return the index of the first unique character
            }
        }

        return -1; // If no unique character found, return -1
    }

    public static void main(String[] args) {
        UniqueCharInString uci = new UniqueCharInString();
        System.out.println(uci.firstUniqChar("leetcode")); // Output: 0
        System.out.println(uci.firstUniqChar("loveleetcode")); // Output: 2
        System.out.println(uci.firstUniqChar("aabb")); // Output: -1
    }
}