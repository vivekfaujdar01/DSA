// LeetCode Problem: Q.225  Implement Stack using Queues
// This code implements a stack using two queues to support LIFO operations.
import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {

    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public StackUsingQueue() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    // Push element x onto stack
    public void push(int x) {
        queue1.offer(x);
    }

    // Removes the element on the top of the stack and returns it
    public int pop() {
        while (queue1.size() > 1) {
            queue2.offer(queue1.poll());
        }
        int topElement = queue1.poll();
        // Swap queues
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        return topElement;
    }

    // Get the top element
    public int top() {
        while (queue1.size() > 1) {
            queue2.offer(queue1.poll());
        }
        int topElement = queue1.peek();
        queue2.offer(queue1.poll());
        // Swap queues
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        return topElement;
    }

    // Returns true if the stack is empty, false otherwise
    public boolean empty() {
        return queue1.isEmpty();
    }

    // Alternative Approach: Using a single queue
    // private Queue<Integer> q;

    // public MyStack() {
    // q = new LinkedList<>();
    // }

    // public void push(int x) {
    // q.add(x);
    // for (int i = 0; i < q.size()-1; i++) {
    // q.add(q.remove());
    // }
    // }

    // public int pop() {
    // return q.remove();
    // }

    // public int top() {
    // return q.peek();
    // }

    // public boolean empty() {
    // return q.isEmpty();
    // }
    public static void main(String[] args) {
        StackUsingQueue myStack = new StackUsingQueue();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top()); // Output: 2
        System.out.println(myStack.pop()); // Output: 2
        System.out.println(myStack.empty()); // Output: false
    }
}