class MyCircularQueue {

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    Node front;
    Node rear;

    int size;
    int capacity;

    public MyCircularQueue(int k) {
        capacity = k;
        size = 0;

        front = null;
        rear = null;
    }

    public boolean enQueue(int value) {

        if (isFull()) {
            return false;
        }

        Node newNode = new Node(value);

        // First node
        if (isEmpty()) {
            front = newNode;
            rear = newNode;

            rear.next = front;
        } else {
            rear.next = newNode;
            rear = newNode;

            rear.next = front;
        }

        size++;

        return true;
    }

    public boolean deQueue() {

        if (isEmpty()) {
            return false;
        }

        // Only one element
        if (front == rear) {
            front = null;
            rear = null;
        } else {
            front = front.next;
            rear.next = front;
        }

        size--;

        return true;
    }

    public int Front() {

        if (isEmpty()) {
            return -1;
        }

        return front.data;
    }

    public int Rear() {

        if (isEmpty()) {
            return -1;
        }

        return rear.data;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */