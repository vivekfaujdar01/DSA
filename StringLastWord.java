// LeetCode
// 58. Length of Last Word
// https://leetcode.com/problems/length-of-last-word/

import java.util.Scanner;
public class StringLastWord {
    public int lengthOfLastWord(String s) {
        int length = 0;
        boolean foundChar = false;
        
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                foundChar = true;
                length++;
            } else if (foundChar) {
                break; // Stop counting when we hit a space after finding the last word
            }
        }
        
        return length;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringLastWord solution = new StringLastWord();
        
        System.out.println("Enter a string:");
        String input = scanner.nextLine();
        
        int result = solution.lengthOfLastWord(input);
        System.out.println("Length of the last word: " + result);
        
        scanner.close();
    }
}
// Time Complexity: O(n)
// Space Complexity: O(1)