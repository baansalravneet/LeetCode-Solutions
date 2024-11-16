class StockSpanner {
        Deque<Integer> prices;
        Deque<Integer> days;
        int count;

    public StockSpanner() {
        prices = new ArrayDeque<>();
        days = new ArrayDeque<>();
        count = 0;
    }
    
    public int next(int price) {
        int answer = 1;
        count++;
        while (!prices.isEmpty() && prices.peekLast() <= price) {
            prices.pollLast();
            days.pollLast();
        }
        if (days.isEmpty()) {
            answer = count;
        } else {
            answer = count - days.peekLast();
        }
        prices.addLast(price);
        days.addLast(count);
        return answer;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
