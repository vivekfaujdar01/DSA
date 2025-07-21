// LeetCode Problem: 23. Merge k Sorted Lists
public class MergeKSortedList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        // Use a priority queue to keep track of the smallest node
        java.util.PriorityQueue<ListNode> minHeap = new java.util.PriorityQueue<>(
            (a, b) -> Integer.compare(a.val, b.val)
        );

        // Add the head of each list to the min heap
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.offer(list);
            }
        }

        // Create a dummy node to simplify the merge process
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        // Merge the k lists
        while (!minHeap.isEmpty()) {
            ListNode smallestNode = minHeap.poll(); // Get the smallest node
            current.next = smallestNode; // Link it to the merged list
            current = current.next; // Move to the next node

            // If there is a next node in the same list, add it to the heap
            if (smallestNode.next != null) {
                minHeap.offer(smallestNode.next);
            }
        }

        return dummy.next; // Return the merged list starting from the next of dummy
    }
    public static void main(String[] args) {
        // Example usage
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(5);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        ListNode list3 = new ListNode(2);
        list3.next = new ListNode(6);

        ListNode[] lists = {list1, list2, list3};

        MergeKSortedList solution = new MergeKSortedList();
        ListNode result = solution.mergeKLists(lists);

        // Print the result
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}