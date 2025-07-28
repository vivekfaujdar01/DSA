// LeetCode
// 503. Next Greater Element II
// https://leetcode.com/problems/next-greater-element-ii/

import java.util.Stack;
public class NextGreaterElement2 {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int nge[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=2*n-1;i>=0;i--){
            while(!st.isEmpty() && st.peek() <= nums[i%n]){
                st.pop();
            }
            if(i<n){
                nge[i] = st.isEmpty() ? -1 : st.peek();
            }
            st.push(nums[i%n]);
        }
        return nge;
    }
    public static void main(String[] args) {
        NextGreaterElement2 solution = new NextGreaterElement2();
        int[] nums = {1, 2, 1 , 12 , 11 , 4, 3, 5, 6, 7, 8, 9};
        int[] result = solution.nextGreaterElements(nums);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
// Time Complexity: O(n)
// Space Complexity: O(n)

