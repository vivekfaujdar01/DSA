class MyHashSet {

    class Node {
        int key;
        Node next;

        Node(int key) {
            this.key = key;
            this.next = null;
        }
    }

    private final int SIZE = 1000;
    private Node[] buckets;

    public MyHashSet() {
        buckets = new Node[SIZE];
    }

    public void add(int key) {

        int index = key % SIZE;

        Node curr = buckets[index];

        // Check if key already exists
        while (curr != null) {
            if (curr.key == key) {
                return;
            }
            curr = curr.next;
        }

        // Insert at the beginning
        Node newNode = new Node(key);
        newNode.next = buckets[index];
        buckets[index] = newNode;
    }

    public void remove(int key) {

        int index = key % SIZE;

        Node curr = buckets[index];
        Node prev = null;

        while (curr != null) {

            if (curr.key == key) {

                if (prev == null) {
                    // Removing the first node
                    buckets[index] = curr.next;
                } else {
                    // Removing a middle or last node
                    prev.next = curr.next;
                }

                return;
            }

            prev = curr;
            curr = curr.next;
        }
    }

    public boolean contains(int key) {

        int index = key % SIZE;

        Node curr = buckets[index];

        while (curr != null) {

            if (curr.key == key) {
                return true;
            }

            curr = curr.next;
        }

        return false;
    }
}
/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */