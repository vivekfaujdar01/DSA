// LeetCode Problem: 142. Linked List Cycle II
// Solved
// LeetCode Problem Difficulty: Medium
// LeetCode Problem Topics: Linked List, Two Pointers

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public class LinkedListCycleStartingPoint {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null; // No cycle if list is empty or has only one node
        }
        ListNode slow = head; // Slow pointer moves one step at a time
        ListNode fast = head; // Fast pointer moves two steps at a time
        while (fast != null && fast.next != null) {
            slow = slow.next; // Move slow pointer by one step
            fast = fast.next.next; // Move fast pointer by two steps
            if (slow == fast) {
                // Cycle detected, find the starting point of the cycle
                ListNode entry = head; // Start from the head
                while (entry != slow) {
                    entry = entry.next; // Move entry pointer by one step
                    slow = slow.next; // Move slow pointer by one step
                }
                return entry; // The starting point of the cycle
            }
        }
        return null; // No cycle found
    }
    public static void main(String[] args) {
        // Example usage
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next; // Creating a cycle

        LinkedListCycleStartingPoint solution = new LinkedListCycleStartingPoint();
        ListNode cycleStart = solution.detectCycle(head);

        if (cycleStart != null) {
            System.out.println("Cycle starts at node with value: " + cycleStart.val); // Output: 2
        } else {
            System.out.println("No cycle detected.");
        }
    }
}

// Alternative approach using a HashSet (not recommended for production use):

// public class Solution {
//     public ListNode detectCycle(ListNode head) {
//         HashSet<ListNode> s=new HashSet<ListNode>(); 
//         for(ListNode curr=head;curr!=null;curr=curr.next) {  
//             if (s.contains(curr)) 
//                 return curr; 
//             s.add(curr); 
//         } 
//         return null;
//     }
// }