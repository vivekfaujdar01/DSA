// Operation	ArrayList	Doubly LinkedList
// pushFront	 O(n)	    O(1)
// pushMiddle	 O(n)	    O(n)
// pushBack	     O(1)	    O(1)
// popFront	     O(n)	    O(1)
// popMiddle	 O(n)	    O(n)
// popBack	     O(1)	    O(1)
class FrontMiddleBackQueue {

    class Node {
        int val;
        Node prev, next;

        Node(int val) {
            this.val = val;
        }
    }

    Node head, tail;
    int size;

    public FrontMiddleBackQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    // Insert node between left and right
    private void insert(Node left, Node right, Node node) {

        node.prev = left;
        node.next = right;

        if (left != null) {
            left.next = node;
        } else {
            head = node;
        }

        if (right != null) {
            right.prev = node;
        } else {
            tail = node;
        }

        size++;
    }

    // Remove a given node
    private int remove(Node node) {

        Node left = node.prev;
        Node right = node.next;

        if (left != null) {
            left.next = right;
        } else {
            head = right;
        }

        if (right != null) {
            right.prev = left;
        } else {
            tail = left;
        }

        size--;

        return node.val;
    }

    // Find node at index
    private Node getNode(int index) {

        Node curr;

        if (index < size / 2) {
            curr = head;

            for (int i = 0; i < index; i++) {
                curr = curr.next;
            }

        } else {
            curr = tail;

            for (int i = size - 1; i > index; i--) {
                curr = curr.prev;
            }
        }

        return curr;
    }

    public void pushFront(int val) {
        insert(null, head, new Node(val));
    }

    public void pushMiddle(int val) {
        int mid = size / 2;
        Node right = (mid == size) ? null : getNode(mid);

        insert(right == null ? tail : right.prev, right, new Node(val));
    }

    public void pushBack(int val) {
        insert(tail, null, new Node(val));
    }

    public int popFront() {
        if (size == 0)
            return -1;
        return remove(head);
    }

    public int popMiddle() {
        if (size == 0)
            return -1;

        int mid = (size - 1) / 2;
        return remove(getNode(mid));
    }

    public int popBack() {
        if (size == 0)
            return -1;
        return remove(tail);
    }
}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */