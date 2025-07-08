// LeetCode Problem Number: 136
// LeetCode Problem Name: Single Number
// LeetCode Problem Link: https://leetcode.com/problems/single-number/
// LeetCode Problem Difficulty: Easy
// LeetCode Problem Topics: Array, Bit Manipulation
// LeetCode Problem Companies: None
// LeetCode Problem Hint: Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
// LeetCode Problem Constraints: 1 <= nums.length <= 3 * 10^4
// LeetCode Problem Solution: Use XOR operation to find the single number in linear time and constant space.
import java.util.*;
public class SingleNumber {
    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num; // XOR operation
        }
        return result; // The single number will remain after all pairs cancel out
    }
    public static void main(String[] args) {
        int[] nums1 = {2, 2, 1};
        int[] nums2 = {4, 1, 2, 1, 2};
        int[] nums3 = {1};

        System.out.println(singleNumber(nums1)); // Output: 1
        System.out.println(singleNumber(nums2)); // Output: 4
        System.out.println(singleNumber(nums3)); // Output: 1
    }
}                      
