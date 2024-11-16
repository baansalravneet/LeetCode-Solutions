class Solution {
    public int trap(int[] height) {
        int answer = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] >= height[stack.peekLast()]) {
                int h = height[stack.pollLast()];
                if (!stack.isEmpty()) {
                    answer += (i - stack.peekLast() - 1) * (Math.min(height[i], height[stack.peekLast()]) - h);
                }
            }
            stack.addLast(i);
        }
        return answer;
    }
}
