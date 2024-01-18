class MyStack {

    Deque<Integer> q1;
    Deque<Integer> q2;

    public MyStack() {
        q1 = new ArrayDeque<>();
        q2 = new ArrayDeque<>();
    }
    
    public void push(int x) {
        while (!q1.isEmpty()) q2.addLast(q1.pollFirst());
        q2.addLast(x);
        while (!q2.isEmpty()) q1.addLast(q2.pollFirst());
    }
    
    public int pop() {
        while (!q1.isEmpty()) q2.addLast(q1.pollFirst());
        int value = q2.pollLast();
        while (!q2.isEmpty()) q1.addLast(q2.pollFirst());
        return value;
    }
    
    public int top() {
        while (!q1.isEmpty()) q2.addLast(q1.pollFirst());
        int value = q2.peekLast();
        while (!q2.isEmpty()) q1.addLast(q2.pollFirst());
        return value;
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
