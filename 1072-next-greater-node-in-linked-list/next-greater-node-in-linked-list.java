/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        // Convert linked list to array
        // Traverse from right to left
        // Maintain decreasing stack for finding next greater element
        List<Integer> values = new ArrayList<>();
        while (head != null) {
            values.add(head.val);
            head = head.next;
        }

        int n = values.size();
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            int curr = values.get(i);

            while (!stack.isEmpty() && stack.peek() <= curr) {
                stack.pop();
            }

            ans[i] = stack.isEmpty() ? 0 : stack.peek();
            stack.push(curr);
        }

        return ans;
    }
}