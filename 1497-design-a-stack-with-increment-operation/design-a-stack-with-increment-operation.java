class CustomStack {
    // Instead of immediately incrementing bottom k elements,
    // store the increment separately and apply it only when popping.
    private int[] stack;
    private int[] inc;
    private int maxSize;
    private int top;

    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
        inc = new int[maxSize];
        top = -1;
    }

    public void push(int x) {
        if (top == maxSize - 1) return;
        stack[++top] = x;
    }

    public int pop() {
        if (top == -1) return -1;

        int res = stack[top] + inc[top];

        if (top > 0) {
            inc[top - 1] += inc[top]; // passing increament value downward 
        }

        inc[top] = 0;
        top--;
        return res;
    }

    public void increment(int k, int val) {
        int idx = Math.min(k, top + 1) - 1; // top+1 = size of stack
        if (idx >= 0) {
            inc[idx] += val;
        }
    }
}


/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */