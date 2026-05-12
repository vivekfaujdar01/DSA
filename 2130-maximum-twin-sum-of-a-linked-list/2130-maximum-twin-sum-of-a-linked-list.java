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

    public int pairSum(ListNode head) {

        // Find middle
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse second half
        ListNode prev = null;
        ListNode curr = slow;

        while (curr != null) {
            ListNode nextNode = curr.next;

            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        // prev = head of reversed second half
        ListNode first = head;
        ListNode second = prev;

        // Find maximum twin sum
        int maxSum = 0;

        while (second != null) {

            int sum = first.val + second.val;

            maxSum = Math.max(maxSum, sum);

            first = first.next;
            second = second.next;
        }

        return maxSum;
    }
}