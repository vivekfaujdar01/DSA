// 2351. First Letter to Appear Twice.java
// LeetCode Problem 2351: First Letter to Appear Twice
// This code finds the first letter in a string that appears twice and returns it. 

import java.util.HashSet;

public class FirstLetterAppearTwice {

    public char repeatedCharacter(String s) {

        HashSet<Character> set = new HashSet<>();
        for(char c : s.toCharArray()){
            if(set.contains(c)){
                return c;
            }
            set.add(c);
        }
        return '\0'; // This line should never be reached given the problem constraints

        // Alternative approach using a boolean array (commented out):

        // Uncomment the following lines if you prefer using a boolean array instead of a HashSet.
        
        // boolean[] seen = new boolean[26]; // Assuming only lowercase English letters

        // for (char c : s.toCharArray()) {
        //     if (seen[c - 'a']) {
        //         return c; // Return the first character that appears twice
        //     }
        //     seen[c - 'a'] = true; // Mark the character as seen
        // }

        // return '\0'; // This line should never be reached given the problem constraints
    }

    public static void main(String[] args) {
        FirstLetterAppearTwice flat = new FirstLetterAppearTwice();
        System.out.println(flat.repeatedCharacter("abccbaacz")); // Output: 'c'
        System.out.println(flat.repeatedCharacter("abcdd")); // Output: 'd'
    }
}


// 2351. First Letter to Appear Twice
// Solved
// Easy
// Topics
// premium lock icon
// Companies
// Hint
// Given a string s consisting of lowercase English letters, return the first letter to appear twice.

// Note:

// A letter a appears twice before another letter b if the second occurrence of a is before the second occurrence of b.
// s will contain at least one letter that appears twice.
 

// Example 1:

// Input: s = "abccbaacz"
// Output: "c"
// Explanation:
// The letter 'a' appears on the indexes 0, 5 and 6.
// The letter 'b' appears on the indexes 1 and 4.
// The letter 'c' appears on the indexes 2, 3 and 7.
// The letter 'z' appears on the index 8.
// The letter 'c' is the first letter to appear twice, because out of all the letters the index of its second occurrence is the smallest.
// Example 2:

// Input: s = "abcdd"
// Output: "d"
// Explanation:
// The only letter that appears twice is 'd' so we return 'd'.
 

// Constraints:

// 2 <= s.length <= 100
// s consists of lowercase English letters.
// s has at least one repeated letter.