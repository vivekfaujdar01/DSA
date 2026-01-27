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
    // we will first reverse list 
    // then we will traverse and check if next node is small then remove that link and jump to next
    // again reverse to list to get result list
    public ListNode removeNodes(ListNode head) {
        head = reverse(head);   // Reverse the list

        ListNode curr = head;

        while (curr.next != null) {              // Traverse and remove nodes
            if (curr.val > curr.next.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
 
        return reverse(head); // Reverse again to restore order
    }
    private ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}