class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] answer = new int[nums.length];
        Arrays.fill(answer, -1);
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < 2*nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peekLast()%n] < nums[i%n]) {
                int index = stack.pollLast();
                if (index >= answer.length) continue;
                answer[index] = nums[i%n];
            }
            stack.addLast(i);
        }
        return answer;
    }
}
