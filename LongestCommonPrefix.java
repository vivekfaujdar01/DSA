// LeetCode Problem: Longest Common Prefix
// LeetCode Problem Difficulty: Easy
// LeetCode Problem Topics: String, Array
// LeetCode Problem Companies: None
// 14. Longest Common Prefix
// Solved

import java.util.Arrays;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String str1 = strs[0];
        String str2 = strs[strs.length-1];
        int index = 0;
        while(index < str1.length()){
            if(str1.charAt(index) == str2.charAt(index)){
                index++;
            }
            else{
                break;
            }
        }
        return index==0 ? "" : str1.substring(0,index);
        // if (strs == null || strs.length == 0) {
        //     return "";
        // }
        
        // String prefix = strs[0];
        
        // for (int i = 1; i < strs.length; i++) {
        //     while (strs[i].indexOf(prefix) != 0) {
        //         prefix = prefix.substring(0, prefix.length() - 1);
        //         if (prefix.isEmpty()) {
        //             return "";
        //         }
        //     }
        // }
        
        // return prefix;
    }
    public static void main(String[] args) {
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        String[] strs1 = {"flower", "flow", "flight"};
        System.out.println(lcp.longestCommonPrefix(strs1)); // Output: "fl"

        String[] strs2 = {"dog", "racecar", "car"};
        System.out.println(lcp.longestCommonPrefix(strs2)); // Output: ""
    }
}



// 14. Longest Common Prefix
// Solved
// Easy
// Topics
// premium lock icon
// Companies
// Write a function to find the longest common prefix string amongst an array of strings.

// If there is no common prefix, return an empty string "".

 

// Example 1:

// Input: strs = ["flower","flow","flight"]
// Output: "fl"
// Example 2:

// Input: strs = ["dog","racecar","car"]
// Output: ""
// Explanation: There is no common prefix among the input strings.
 

// Constraints:

// 1 <= strs.length <= 200
// 0 <= strs[i].length <= 200
// strs[i] consists of only lowercase English letters if it is non-empty.