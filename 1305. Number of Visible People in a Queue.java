class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] answer = new int[heights.length];
        for (int i = heights.length-1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[i] > stack.peekLast()) {
                answer[i]++;
                stack.pollLast();
            }
            if (!stack.isEmpty()) {
                answer[i]++;
            }
            stack.addLast(heights[i]);
        }
        return answer;
    }
}


