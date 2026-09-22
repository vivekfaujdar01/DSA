class MinStack {
    // in this we will maintain minimum of every element in another stack 
    Stack<Integer> mainSt;
    Stack<Integer> auxSt;
    public MinStack() {
        mainSt = new Stack<>();
        auxSt = new Stack<>();
    }
    
    public void push(int val) {
        mainSt.push(val);
        if(auxSt.isEmpty()){
            auxSt.push(val);
            return;
        }
        else{
            auxSt.push(Math.min(val, auxSt.peek()));
        }      
    }
    
    public void pop() {
        auxSt.pop();
        mainSt.pop();
    }
    
    public int top() {
        return mainSt.peek();
    }
    
    public int getMin() {
        return auxSt.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */