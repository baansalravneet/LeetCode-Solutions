class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        stack.addLast(0);
        for (int i = n-1; i >= 0; i--) {
            int currentTemperature = temperatures[i];
            while (stack.peekLast() != 0 && temperatures[stack.peekLast()] <= currentTemperature) {
                stack.pollLast();
            }
            answer[i] = stack.peekLast() == 0 ? 0 : stack.peekLast() - i;
            stack.addLast(i);
        }
        return answer;
    }
}
