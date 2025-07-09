// LeetCode Problem: https://leetcode.com/problems/plus-one/
// File: PlusOne.java
// LeetCode Problem Number: 66
// LeetCode Problem Name: Plus One
// LeetCode Problem Link: https://leetcode.com/problems/plus-one/
// LeetCode Problem Difficulty: Easy
// LeetCode Problem Topics: Array, Math
// LeetCode Problem Companies: None
public class PlusOne {
    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0; // Set current digit to 0 if it was 9
        }
        // If we reach here, it means all digits were 9, so we need to
        // create a new array with an additional digit
        int[] newDigits = new int[n + 1];
        newDigits[0] = 1; // Set the first digit to 1
        // The rest are already 0 by default
        return newDigits;
    }

    public static void main(String[] args) {
        int[] digits1 = { 1, 2, 3 };
        int[] result1 = plusOne(digits1);
        for (int digit : result1) {
            System.out.print(digit + " ");
        }
        System.out.println(); // Output: 1 2 4

        int[] digits2 = { 4, 3, 2, 1 };
        int[] result2 = plusOne(digits2);
        for (int digit : result2) {
            System.out.print(digit + " ");
        }
        System.out.println(); // Output: 4 3 2 2

        int[] digits3 = { 9 };
        int[] result3 = plusOne(digits3);
        for (int digit : result3) {
            System.out.print(digit + " ");
        }
        System.out.println(); // Output: 1 0
    }
}