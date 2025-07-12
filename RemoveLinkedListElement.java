// LeetCode Problem: 203. Remove Linked List Elements
// This code implements the removeElements function which removes all nodes with a specific value from a linked list.
// The function returns the new head of the modified list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class RemoveLinkedListElement {
    public ListNode removeElements(ListNode head, int val) {
        // Create a dummy node to handle edge cases like removing the head
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        // Traverse the list
        while (current.next != null) {
            // If the next node's value is equal to val, skip it
            if (current.next.val == val) {
                current.next = current.next.next;
            } else {
                // Otherwise, move to the next node
                current = current.next;
            }
        }
        // Return the new head, which is the next of the dummy node
        return dummy.next;
        
        // Alternative approach without using a dummy node
        // Uncomment the following lines to use this approach

        // while(head != null && head.val == val){
        //     head = head.next;
        // }
        // if(head == null){
        //     return null;
        // }
        // ListNode curr = head;
        // while(curr.next != null){
        //     if(curr.next.val == val){
        //         curr.next = curr.next.next;
        //     }
        //     else{
        //         curr = curr.next;
        //     }
        // }
        // return head;

    }
    public static void main(String[] args) {
        // Example usage
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);

        RemoveLinkedListElement solution = new RemoveLinkedListElement();
        ListNode newHead = solution.removeElements(head, 6);

        // Print the modified list
        ListNode current = newHead;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        // Output: 1 2 3 4 5
    }
}
// LeetCode Problem: 203. Remove Linked List Elements



// 203. Remove Linked List Elements
// Solved
// Easy
// Topics
// premium lock icon
// Companies
// Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.

 

// Example 1:


// Input: head = [1,2,6,3,4,5,6], val = 6
// Output: [1,2,3,4,5]
// Example 2:

// Input: head = [], val = 1
// Output: []
// Example 3:

// Input: head = [7,7,7,7], val = 7
// Output: []
 

// Constraints:

// The number of nodes in the list is in the range [0, 104].
// 1 <= Node.val <= 50
// 0 <= val <= 50