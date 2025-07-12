//LeetCode Problem: 237. Delete Node in a Linked List
// This code implements the deleteNode function
// which deletes a given node from a singly linked list without access to the head of the list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class DeleteNodeInLinkedList {
    public void deleteNode(ListNode node) {
        // Copy the value from the next node to the current node
        node.val = node.next.val;
        // Bypass the next node
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        // Example usage
        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);

        DeleteNodeInLinkedList solution = new DeleteNodeInLinkedList();
        solution.deleteNode(head.next); // Deleting node with value 5

        // Print the modified list
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        // Output: 4 1 9
    }
}