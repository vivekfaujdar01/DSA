 // we can use hashset, like add all nodes of headA in set then check while looping headB if nodes references are same.
 // we can also use length difference method, like there is a difference if they are having common part then find length both get both of list at the same distance from common part and when check until they both refer to common part.
 // and last method is pointing a to head of b after null or its vice-versa for b, because at the end they will refer to same part that could be null or common part.
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
    
        ListNode a = headA;
        ListNode b = headB;

        while( a != b){
           a = a == null? headB : a.next;
           b = b == null? headA : b.next;    
        }
    
        return a;
    }
}

// public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//     HashSet<ListNode> set = new HashSet<>();

//     while (headA != null) {
//         set.add(headA);
//         headA = headA.next;
//     }
//     while (headB != null) {
//         if (set.contains(headB))
//             return headB;

//         headB = headB.next;
//     }
//     return null;
// }

// public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
//     int lenA = getLength(headA);
//     int lenB = getLength(headB);
//     while (lenA > lenB) {
//         headA = headA.next;
//         lenA--;
//     }
//     while (lenB > lenA) {
//         headB = headB.next;
//         lenB--;
//     }
//     while (headA != headB) {
//         headA = headA.next;
//         headB = headB.next;
//     }
//     return headA;
// }
// private int getLength(ListNode head) {
//     int len = 0;
//     while (head != null) {
//         len++;
//         head = head.next;
//     }
//     return len;
// }