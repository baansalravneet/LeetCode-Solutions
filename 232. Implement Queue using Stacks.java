class MyQueue {

    private Deque<Integer> stack1;
    private Deque<Integer> stack2;

    public MyQueue() {
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
    }
    
    public void push(int x) {
        stack1.addLast(x);
    }
    
    public int pop() {
        while (!stack1.isEmpty()) {
            stack2.addLast(stack1.pollLast());
        }
        int value = stack2.pollLast();
        while (!stack2.isEmpty()) {
            stack1.addLast(stack2.pollLast());
        }
        return value;
    }
    
    public int peek() {
        while (!stack1.isEmpty()) {
            stack2.addLast(stack1.pollLast());
        }
        int value = stack2.peekLast();
        while (!stack2.isEmpty()) {
            stack1.addLast(stack2.pollLast());
        }
        return value;
    }
    
    public boolean empty() {
        return stack1.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
