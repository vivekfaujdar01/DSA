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

        boolean[] exists = new boolean[100001];

        for (int num : nums) {
            exists[num] = true;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null) {

            if (exists[curr.val]) {
                prev.next = curr.next;

            } else {
                prev = curr;
            }

            curr = curr.next;
        }

        return dummy.next;
    }
}
