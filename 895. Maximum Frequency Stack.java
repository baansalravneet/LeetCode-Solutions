class FreqStack {
    Map<Integer, Deque<Integer>> freqToNum;
    int maxFreq;
    Map<Integer, Integer> numToFreq;

    public FreqStack() {
        freqToNum = new HashMap<>();
        numToFreq = new HashMap<>();
        maxFreq = 0;
    }
    
    public void push(int val) {
        int nextFreq = numToFreq.getOrDefault(val, 0) + 1;
        freqToNum.computeIfAbsent(nextFreq, k -> new ArrayDeque<>()).addLast(val);
        numToFreq.put(val, nextFreq);
        maxFreq = Math.max(maxFreq, nextFreq);
    }
    
    public int pop() {
        Deque<Integer> stack = freqToNum.get(maxFreq);
        int answer = stack.pollLast();
        if (stack.isEmpty()) {
            maxFreq--;
        }
        numToFreq.put(answer, numToFreq.get(answer) - 1);
        return answer;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */
