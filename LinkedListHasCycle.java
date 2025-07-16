//LeetCode Problem: 141. Linked List Cycle
// Solved
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class LinkedListHasCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false; // If the list is empty or has only one node, no cycle
        }
        ListNode slow = head; // Slow pointer moves one step at a time
        ListNode fast = head; // Fast pointer moves two steps at a time
        while (fast != null && fast.next != null) {
            slow = slow.next; // Move slow pointer by one step
            fast = fast.next.next; // Move fast pointer by two steps
            if (slow == fast) {
                return true; // If slow and fast pointers meet, there is a cycle
            }
        }
        return false; // If fast pointer reaches the end, no cycle exists
    }  
    public static void main(String[] args) {
        // Example usage
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next; // Creating a cycle

        LinkedListHasCycle solution = new LinkedListHasCycle();
        boolean hasCycle = solution.hasCycle(head);

        System.out.println("Has Cycle: " + hasCycle); // Output: true
    }
}
// Alternative approach using a temporary node (not recommended for production use):
// public class Solution {
//     public boolean hasCycle(ListNode head) {
//         ListNode temp = new ListNode();
//         while(head != null){
//             if(head.next == null){
//                 return false;
//             }
//             if(head.next == temp){
//                 return true;
//             }
//             ListNode next = head.next;
//             head.next = temp;
//             head = next;
//         }
//         return false;
//     }
// }
//Another approach is to use a HashSet to store visited nodes, but it uses extra space.
// This approach is more space-efficient and does not modify the list.
// public class Solution {
//     public boolean hasCycle(ListNode head) {
//         Set<ListNode> visited = new HashSet<>();
//         while(head != null){
//             if(visited.contains(head)){
//                 return true; // Cycle detected
//             }
//             visited.add(head); // Add the current node to the set
//             head = head.next; // Move to the next node
//         }
//         return false; // No cycle detected
//     }
// }
