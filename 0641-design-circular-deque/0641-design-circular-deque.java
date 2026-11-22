// Using doubly linked list
class MyCircularDeque {

    class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    Node front;
    Node rear;

    int size;
    int capacity;

    public MyCircularDeque(int k) {
        front = null;
        rear = null;

        size = 0;
        capacity = k;
    }

    public boolean insertFront(int value) {

        if (isFull()) {
            return false;
        }

        Node newNode = new Node(value);

        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } 
        else {
            newNode.next = front;
            front.prev = newNode;
            front = newNode;
        }

        size++;

        return true;
    }

    public boolean insertLast(int value) {

        if (isFull()) {
            return false;
        }

        Node newNode = new Node(value);

        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } 
        else {
            rear.next = newNode;
            newNode.prev = rear;
            rear = newNode;
        }

        size++;

        return true;
    }

    public boolean deleteFront() {

        if (isEmpty()) {
            return false;
        }

        if (size == 1) {
            front = null;
            rear = null;
        } 
        else {
            front = front.next;
            front.prev = null;
        }

        size--;

        return true;
    }

    public boolean deleteLast() {

        if (isEmpty()) {
            return false;
        }

        if (size == 1) {
            front = null;
            rear = null;
        } 
        else {
            rear = rear.prev;
            rear.next = null;
        }

        size--;

        return true;
    }

    public int getFront() {

        if (isEmpty()) {
            return -1;
        }

        return front.data;
    }

    public int getRear() {

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
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */