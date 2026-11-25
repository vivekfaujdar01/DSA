class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {

        // Calculate the length
        int n = 0;
        ListNode temp = head;

        while (temp != null) {
            n++;
            temp = temp.next;
        }

        // Calculate distribution
        int base = n / k;
        int extra = n % k;

        ListNode[] result = new ListNode[k];

        // Split the linked list
        ListNode curr = head;

        for (int i = 0; i < k; i++) {

            // Determine size of current part
            int size = base;

            if (i < extra) {
                size++;
            }

            // Store the head of current part
            result[i] = curr;

            // Move to the last node of current part
            for (int j = 1; j < size; j++) {
                if (curr != null) {
                    curr = curr.next;
                }
            }

            // Disconnect current part
            if (curr != null) {
                ListNode next = curr.next;
                curr.next = null;
                curr = next;
            }
        }

        return result;
    }
}
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
