// LeetCode Problem: 83. Remove Duplicates from Sorted List
// LeetCode Problem Difficulty: Easy
// LeetCode Problem Topics: Linked List, Two Pointers

public class RemoveDuplicatesFromLinkedList {
    public ListNode removeElements(ListNode head, int val) {
        // Handle the case where the head itself needs to be removed
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) {
            return null; // If the list is empty after removing the head
        }

        ListNode curr = head;
        while (curr.next != null) {
            if (curr.next.val == val) {
                curr.next = curr.next.next; // Skip the node with the value
            } else {
                curr = curr.next; // Move to the next node
            }
        }
        return head; // Return the modified list
    }

    static class ListNode {
        int val;
        ListNode next;
        
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public static void main(String[] args) {
        // Example usage
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);

        RemoveDuplicatesFromLinkedList solution = new RemoveDuplicatesFromLinkedList();
        ListNode newHead = solution.removeElements(head, 1);

        // Print the modified list
        ListNode current = newHead;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        // Output: 2 3
    }
}
