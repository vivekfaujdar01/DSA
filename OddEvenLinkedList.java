// LeetCode : Q328. Odd Even Linked List
// Problem Link: https://leetcode.com/problems/odd-even-linked-list/
// Difficulty: Medium
// Tags: Linked List, Two Pointers
public class OddEvenLinkedList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode odd = head, even = head.next, evenHead = even;

        while (even != null && even.next != null) {
            odd.next = odd.next.next; // Link odd nodes
            even.next = even.next.next; // Link even nodes
            odd = odd.next; // Move to next odd node
            even = even.next; // Move to next even node
        }

        odd.next = evenHead; // Connect the end of odd list to the head of even list
        return head;

        // Alternative approach using two pointers
        // ListNode es = null, ee = null , os = null , oe = null;
        // ListNode curr = head;
        // int count = 1;
        // while(curr != null){
        //     if(count%2 == 0){
        //         if(es == null){
        //             es = curr;
        //             ee = es;
        //         }
        //         else{
        //             ee.next = curr;
        //             ee = ee.next;
        //         }
        //     }
        //     else{
        //         if(os == null){
        //             os = curr;
        //             oe = os;
        //         }
        //         else{
        //             oe.next = curr;
        //             oe = oe.next;
        //         }
        //     }
        //     count++;
        //     curr = curr.next;
        // }
        // if(os == null || es == null)    return head;
        // oe.next = es;
        // ee.next = null;
        // head = os;
        // return head;
    }
    // Definition for singly-linked list.
    public static void main(String[] args) {
        // Example usage
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        OddEvenLinkedList solution = new OddEvenLinkedList();
        ListNode result = solution.oddEvenList(head);

        // Print the result
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}