// all methods performed in O(1) , we use two deques to solve it
class FrontMiddleBackQueue {

    Deque<Integer> front;
    Deque<Integer> back;

    public FrontMiddleBackQueue() {
        front = new ArrayDeque<>();
        back = new ArrayDeque<>();
    }

    // Maintain the size condition
    private void balance() {

        if (front.size() > back.size() + 1) {
            back.addFirst(front.removeLast());
        } else if (front.size() < back.size()) {
            front.addLast(back.removeFirst());
        }
    }

    public void pushFront(int val) {

        front.addFirst(val);
        balance();
    }

    public void pushMiddle(int val) {

        if (front.size() > back.size()) {
            back.addFirst(front.removeLast());
        }

        front.addLast(val);
    }

    public void pushBack(int val) {

        back.addLast(val);
        balance();
    }

    public int popFront() {

        if (front.isEmpty() && back.isEmpty()) {
            return -1;
        }

        int val;

        if (!front.isEmpty()) {
            val = front.removeFirst();
        } else {
            val = back.removeFirst();
        }

        balance();

        return val;
    }

    public int popMiddle() {

        if (front.isEmpty()) {
            return -1;
        }

        int val = front.removeLast();

        balance();

        return val;
    }

    public int popBack() {

        if (front.isEmpty() && back.isEmpty()) {
            return -1;
        }

        int val;

        if (!back.isEmpty()) {
            val = back.removeLast();
        } else {
            val = front.removeLast();
        }

        balance();

        return val;
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