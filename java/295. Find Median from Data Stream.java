class MedianFinder {

    Queue<Integer> leftSide;
    Queue<Integer> rightSide;

    public MedianFinder() {
        leftSide = new PriorityQueue<>((a,b) -> b - a);
        rightSide = new PriorityQueue<>((a,b) -> a - b);
    }
    
    public void addNum(int num) {
        if (leftSide.size() > rightSide.size()) rightSide.add(num);
        else leftSide.add(num);
        if (!leftSide.isEmpty() && !rightSide.isEmpty() && leftSide.peek() > rightSide.peek()) {
            int left = leftSide.poll();
            int right = rightSide.poll();
            rightSide.add(left);
            leftSide.add(right);
        }
    }
    
    public double findMedian() {
        if ((leftSide.size() + rightSide.size()) % 2 == 0) {
            return (double)(leftSide.peek() + rightSide.peek()) / 2;
        }
        return leftSide.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
