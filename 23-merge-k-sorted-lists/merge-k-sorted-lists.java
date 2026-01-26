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
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0) {
            return null;
        }

        // Min Heap based on node value
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add the head of each list
        for (ListNode node : lists) {
            if (node != null) {
                minHeap.offer(node);
            }
        }

        // Dummy node to simplify result handling
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        while (!minHeap.isEmpty()) {
            // Get smallest node
            ListNode curr = minHeap.poll();
            tail.next = curr;
            tail = tail.next;

            // Push next node from the same list
            if (curr.next != null) {
                minHeap.offer(curr.next);
            }
        }

        return dummy.next;
    }
}