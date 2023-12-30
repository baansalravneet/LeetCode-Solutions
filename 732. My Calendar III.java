class MyCalendarThree {

    List<Integer> times;

    public MyCalendarThree() {
        times = new ArrayList<>();
    }
    
    public int book(int startTime, int endTime) {
        times.add(startTime);
        times.add(-endTime);
        Collections.sort(times, (a,b) -> {
            if (Math.abs(a) == Math.abs(b)) {
                return a-b;
            }
            return Math.abs(a) - Math.abs(b);
        });
        int count = 0;
        int result = 0;
        for (int i = 0; i < times.size(); i++) {
            if (times.get(i) < 0) {
                count--;
            } else {
                count++;
            }
            result = Math.max(result, count);
        }
        return result;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(startTime,endTime);
 */