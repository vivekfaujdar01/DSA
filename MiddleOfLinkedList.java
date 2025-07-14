// LeetCode Problem: 876. Middle of the Linked List
// Solved
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class MiddleOfLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        // Move fast pointer two steps and slow pointer one step
        while (fast != null && fast.next != null) {
            slow = slow.next; // Move slow pointer by one step
            fast = fast.next.next; // Move fast pointer by two steps
        }
        // When fast pointer reaches the end, slow pointer will be at the middle
        return slow; // Return the middle node
    }
    public static void main(String[] args) {
        // Example usage
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        MiddleOfLinkedList solution = new MiddleOfLinkedList();
        ListNode middle = solution.middleNode(head);

        // Print the middle node
        System.out.println("Middle Node Value: " + middle.val); // Output: 3
    }
}




// 876. Middle of the Linked List
// Solved
// Easy
// Topics
// premium lock icon
// Companies
// Given the head of a singly linked list, return the middle node of the linked list.

// If there are two middle nodes, return the second middle node.

 

// Example 1:


// Input: head = [1,2,3,4,5]
// Output: [3,4,5]
// Explanation: The middle node of the list is node 3.
// Example 2:


// Input: head = [1,2,3,4,5,6]
// Output: [4,5,6]
// Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
 

// Constraints:

// The number of nodes in the list is in the range [1, 100].
// // 1 <= Node.val <= 100