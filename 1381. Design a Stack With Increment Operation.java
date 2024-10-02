class CustomStack {
    private int maxSize;
    private int[] elements;
    private int[] incs;
    private int index;
    private int current;

    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
        elements = new int[maxSize];
        incs = new int[maxSize];
        index = 0;
        current = 0;
    }
    
    public void push(int x) {
        if (index < maxSize) {
            if (index != 0) {
                incs[index-1] += current;
                current = 0;
            }
            elements[index] = x;
            incs[index] = 0;
            index++;
        }
    }
    
    public int pop() {
        if (index == 0) return -1;
        index--;
        current += incs[index];
        int val = current + elements[index];
        incs[index] = 0;
        if (index == 0) current = 0;
        return val;
    }
    
    public void increment(int k, int val) {
        if (index == 0) return;
        if (k >= index) incs[index-1] += val;
        else incs[k-1] += val;
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */