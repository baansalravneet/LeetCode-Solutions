class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i : asteroids) {
            if (i > 0 || stack.isEmpty() || stack.peekLast() < 0) {
                stack.addLast(i);
                continue;
            }
            if (i < 0) {
                while (!stack.isEmpty() && stack.peekLast() > 0 && stack.peekLast() < -i) {
                    stack.pollLast();
                }
                if (!stack.isEmpty() && stack.peekLast() > -i) {
                    continue;
                }
                if (!stack.isEmpty() && stack.peekLast() == -i) {
                    stack.pollLast();
                    continue;
                }
                stack.addLast(i);
            }
        }
        int index = stack.size()-1;
        int[] answer = new int[index+1];
        while (!stack.isEmpty()) answer[index--] = stack.pollLast();
        return answer;
    }
}
