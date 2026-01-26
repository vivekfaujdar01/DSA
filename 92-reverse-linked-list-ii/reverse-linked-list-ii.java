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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode prev = dummy;
        for (int i = 1; i < left; i++) {  // [1,2,3,4,5] after this loop prev will point to 1
            prev = prev.next;
        }

        // key points to understand-:
        // prev NEVER moves
        // It always points to node before the sublist
        // curr NEVER moves
        // It becomes the tail of reversed portion
        // We always move curr.next

        ListNode curr = prev.next; // [1,2,3,4,5] curr = 2 , next = 3 , prev = 1
        for (int i = 0; i < right - left; i++) {
            ListNode next = curr.next;
            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
        }

        return dummy.next;
    }
}