//LeetCode Problem: 203. Remove Linked List Elements
// Solved
 class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
}
public class ReverseLinkedList {

        public ListNode reverseList(ListNode head) {
            ListNode prev = null;
            ListNode curr = head;
            while (curr != null) {
                ListNode nextTemp = curr.next; // Store the next node
                curr.next = prev; // Reverse the link
                prev = curr; // Move prev to current node
                curr = nextTemp; // Move to the next node
            }
            return prev; // New head of the reversed list
        }
        public static void main(String[] args) {
            // Example usage
            ListNode head = new ListNode(1);
            head.next = new ListNode(2);
            head.next.next = new ListNode(3);
            head.next.next.next = new ListNode(4);
            head.next.next.next.next = new ListNode(5);

            ReverseLinkedList solution = new ReverseLinkedList();
            ListNode reversedHead = solution.reverseList(head);

            // Print the reversed list
            ListNode current = reversedHead;
            while (current != null) {
                System.out.print(current.val + " ");
                current = current.next;
            }
            // Output: 5 4 3 2 1
        }
    
}