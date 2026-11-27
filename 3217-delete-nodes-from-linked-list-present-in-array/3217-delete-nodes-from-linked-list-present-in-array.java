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
    public ListNode modifiedList(int[] nums, ListNode head) {

        // Store nums elements in HashSet
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;

        // Traverse linked list
        while (curr != null) {

            if (set.contains(curr.val)) {
                prev.next = curr.next; // Delete current node
            } else {
                prev = curr; // Keep current node
            }

            curr = curr.next;
        }

        return dummy.next;
    }
}
