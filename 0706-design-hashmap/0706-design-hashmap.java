class MyHashMap {

    class Node {
        int key;
        int value;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int capacity = 1009;
    Node[] buckets;

    public MyHashMap() {
        buckets = new Node[capacity];
    }

    private int hash(int key) {
        return key % capacity;
    }

    public void put(int key, int value) {

        int index = hash(key);

        Node current = buckets[index];

        // Check whether key already exists
        while (current != null) {

            if (current.key == key) {
                current.value = value;
                return;
            }

            current = current.next;
        }

        // Insert new node at the beginning
        Node newNode = new Node(key, value);

        newNode.next = buckets[index];
        buckets[index] = newNode;
    }

    public int get(int key) {

        int index = hash(key);

        Node current = buckets[index];

        while (current != null) {

            if (current.key == key) {
                return current.value;
            }

            current = current.next;
        }

        return -1;
    }

    public void remove(int key) {

        int index = hash(key);

        Node current = buckets[index];
        Node previous = null;

        while (current != null) {

            if (current.key == key) {

                if (previous == null) {
                    buckets[index] = current.next;
                } 
                else {
                    previous.next = current.next;
                }

                return;
            }

            previous = current;
            current = current.next;
        }
    }
}
