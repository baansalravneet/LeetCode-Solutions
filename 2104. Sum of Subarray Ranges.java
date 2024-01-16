class Solution {
    public long subArrayRanges(int[] nums) {
        int[] leftMin = getLeft(nums, true);
        int[] rightMin = getRight(nums, true);
        int[] leftMax = getLeft(nums, false);
        int[] rightMax = getRight(nums, false);
        long answer = 0;
        for (int i = 0; i < nums.length; i++) {
            int left = leftMax[i];
            int right = rightMax[i];
            answer += (long)nums[i] * (rightMax[i] - i) * (i - leftMax[i]);
            answer -= (long)nums[i] * (rightMin[i] - i) * (i - leftMin[i]);
        }
        return answer;
    }
    private int[] getLeft(int[] nums, boolean min) {
        int[] result = new int[nums.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() &&
                    (min ? (nums[stack.peekLast()] >= nums[i]) : (nums[stack.peekLast()] <= nums[i]))) {
                stack.pollLast();
            }
            result[i] = stack.isEmpty() ? -1 : stack.peekLast();
            stack.addLast(i);
        }
        return result;
    }
    private int[] getRight(int[] nums, boolean min) {
        int[] result = new int[nums.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = nums.length-1; i >= 0; i--) {
            while (!stack.isEmpty() &&
                    (min ? (nums[stack.peekLast()] > nums[i]) : (nums[stack.peekLast()] < nums[i]))) {
                stack.pollLast();
            }
            result[i] = stack.isEmpty() ? nums.length : stack.peekLast();
            stack.addLast(i);
        }
        return result;
    }
}
