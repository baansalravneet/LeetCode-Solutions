class Solution {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int answer = 0;
        int i = 0;
        for (; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[i] <= heights[stack.peekLast()]) {
                int height = heights[stack.pollLast()];
                if (stack.isEmpty()) answer = Math.max(answer, i * height);
                else answer = Math.max(answer, height*(i-stack.peekLast()-1));
            }
            stack.addLast(i);
        }
        while (!stack.isEmpty()) {
            int height = heights[stack.pollLast()];
            if (stack.isEmpty()) answer = Math.max(answer, i * height);
            else answer = Math.max(answer, height * (i-stack.peekLast()-1));
        }
        return answer;
    }
}