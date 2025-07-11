// ValidPalindrome.java
// LeetCode Problem: https://leetcode.com/problems/valid-palindrome/    
// LeetCode Problem Difficulty: Easy
// LeetCode Problem Topics: String, Two Pointers
// LeetCode Problem Companies: None 
// 125. Valid Palindrome
// Given a string s, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        
        s = s.toLowerCase();
        int left = 0, right = s.length() - 1;
        
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }

    public static void main(String[] args) {
        ValidPalindrome vp = new ValidPalindrome();
        System.out.println(vp.isPalindrome("asdffdsa")); // Example test case
        System.out.println(vp.isPalindrome("A man, a plan, a canal: Panama")); // true
        System.out.println(vp.isPalindrome("race a car")); // false
        System.out.println(vp.isPalindrome("")); // true
        System.out.println(vp.isPalindrome(" ")); // true
        System.out.println(vp.isPalindrome("No lemon, no melon")); // true
    }
}
        