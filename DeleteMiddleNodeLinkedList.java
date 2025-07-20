// LeetCode Problem: 2095. Delete the Middle Node of a Linked List
public class DeleteMiddleNodeLinkedList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) return null;

        ListNode slow = head, fast = head, prev = null;

        while (fast != null && fast.next != null) {
            prev = slow; // Keep track of the previous node
            slow = slow.next; // Move slow pointer by one
            fast = fast.next.next; // Move fast pointer by two
        }

        // Remove the middle node
        if (prev != null) {
            prev.next = slow.next; // Link previous node to the next of slow
        }

        return head;

        // Alternative Approach
        // ListNode dummy = new ListNode(-1);
        // dummy.next = head;
        // ListNode slow = dummy , fast = head;
        // while(fast != null && fast.next != null){
        //     slow = slow.next;
        //     fast = fast.next.next;
        // }
        // slow.next = slow.next.next;
        // return dummy.next; 
    }

    public static void main(String[] args) {
        // Example usage
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        DeleteMiddleNodeLinkedList solution = new DeleteMiddleNodeLinkedList();
        ListNode result = solution.deleteMiddle(head);

        // Print the result
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
