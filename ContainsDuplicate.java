// File: ContainsDuplicate.java
// LeetCode Problem Number: 217
// LeetCode Problem Name: Contains Duplicate
// LeetCode Problem Link: https://leetcode.com/problems/contains-duplicate/
// LeetCode Problem Difficulty: Easy
// LeetCode Problem Topics: Array, Hash Table
// LeetCode Problem Companies: None                 
import java.util.HashSet;
public class ContainsDuplicate {
    public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 1};
        int[] nums2 = {1, 2, 3, 4};
        int[] nums3 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};

        System.out.println(containsDuplicate(nums1)); // Output: true
        System.out.println(containsDuplicate(nums2)); // Output: false
        System.out.println(containsDuplicate(nums3)); // Output: true
    }
}