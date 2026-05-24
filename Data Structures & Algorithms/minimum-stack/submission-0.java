class MinStack {
    Deque<Integer> stk = new ArrayDeque<>();
    Deque<Integer> mini = new ArrayDeque<>();

    public MinStack() {

    }

    public void push(int val) {
        stk.push(val);
        if (mini.isEmpty() || mini.peek() >= val) {
            mini.push(val);
        }
    }

    public void pop() {
        if (mini.peek().equals(stk.peek()))
            mini.pop();
        stk.pop();
    }

    public int top() {
        return stk.peek();
    }

    public int getMin() {
        return mini.peek();
    }
}
