class MinStack {
private int[] stack;
    private int[] minStack;
    private int top;

    public MinStack() {
        stack = new int[30001];
        minStack = new int[30001];
        top = -1;
    }
    
    public void push(int val) {
        top++;
        stack[top] = val;
        if (top == 0) {
            minStack[top] = val;
        } else {
            minStack[top] = Math.min(val, minStack[top - 1]);
        }
    }
    
    public void pop() {
        top--;
    }
    
    public int top() {
        return stack[top];
    }
    
    public int getMin() {
        return minStack[top];
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