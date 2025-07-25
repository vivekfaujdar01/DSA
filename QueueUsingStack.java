//LeetCode Problem 232: Implement Queue using Stacks
// This code implements a queue using two stacks to support FIFO operations.
import java.util.Stack;
public class QueueUsingStack {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public QueueUsingStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Push element x to the back of the queue
    public void push(int x) {
        stack1.push(x);
    }

    // Removes the element from the front of the queue and returns it
    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    // Returns the element at the front of the queue
    public int peek() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    // Returns true if the queue is empty, false otherwise
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public static void main(String[] args) {
        QueueUsingStack myQueue = new QueueUsingStack();
        myQueue.push(1);
        myQueue.push(2);
        System.out.println(myQueue.peek()); // Output: 1
        System.out.println(myQueue.pop());  // Output: 1
        System.out.println(myQueue.empty()); // Output: false
    }
}