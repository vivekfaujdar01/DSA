
// File: IntersectionArray.java
// LeetCode Problem: https://leetcode.com/problems/intersection-of-two-arrays/
// File: IntersectionArray.java
// LeetCode Problem Number: 349
// LeetCode Problem Name: Intersection of Two Arrays
// LeetCode Problem Link: https://leetcode.com/problems/intersection-of-two-arrays/
// LeetCode Problem Difficulty: Easy
// LeetCode Problem Topics: Array, Hash Table
// LeetCode Problem Companies: None
import java.util.HashSet;

public class IntersectionArray {
    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i : nums1)
            hs.add(i);

        HashSet<Integer> resultSet = new HashSet<>();
        for (int num : nums2) {
            if (hs.contains(num)) {
                resultSet.add(num);
            }
        }
        // Convert the HashSet to an array
        int[] result = new int[resultSet.size()];
        int index = 0;
        for (int num : resultSet) {
            result[index++] = num;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = { 1, 2, 2, 1 };
        int[] nums2 = { 2, 2 };
        int[] result = intersection(nums1, nums2);
        for (int num : result) {
            System.out.print(num + " "); // Output: 2
        }
    }
}

// 349. Intersection of Two Arrays
// Solved
// Easy
// Topics
// premium lock icon
// Companies
// Given two integer arrays nums1 and nums2, return an array of their
// intersection. Each element in the result must be unique and you may return
// the result in any order.

// Example 1:

// Input: nums1 = [1,2,2,1], nums2 = [2,2]
// Output: [2]
// Example 2:

// Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
// Output: [9,4]
// Explanation: [4,9] is also accepted.

// Constraints:

// 1 <= nums1.length, nums2.length <= 1000
// 0 <= nums1[i], nums2[i] <= 1000
// Seen this question in a real interview before?
// 1/5
// Yes
// No
// Accepted
// 1,556,286/2M
// Acceptance Rate
// 76.6%
// Topics
// icon
// Companies