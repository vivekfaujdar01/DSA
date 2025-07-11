// ValidAnagram.java// LeetCode Problem 242: Valid Anagram
// This code checks if two strings are anagrams of each other.
// An anagram is a word or phrase formed by rearranging the letters
// of a different word or phrase, typically using all the original letters exactly once.
// The solution uses a character count array to compare the frequency of each character in both strings.

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] charCount = new int[26]; // Assuming only lowercase English letters

        for (int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i) - 'a']++;
            charCount[t.charAt(i) - 'a']--;
        }

        for (int count : charCount) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }
    public static void main(String[] args) {
        ValidAnagram va = new ValidAnagram();
        System.out.println(va.isAnagram("anagram", "nagaram")); // true
        System.out.println(va.isAnagram("rat", "car")); // false
    }
}