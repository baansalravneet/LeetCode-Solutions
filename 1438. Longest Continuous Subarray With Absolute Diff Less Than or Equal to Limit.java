class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> maxQ = new LinkedList<>();
        Deque<Integer> minQ = new LinkedList<>();
        int left = 0;
        int answer = 0;
        for (int right = 0; right < nums.length; right++) {
            while (!maxQ.isEmpty() && maxQ.peekLast() < nums[right]) maxQ.pollLast();
            while (!minQ.isEmpty() && minQ.peekLast() > nums[right]) minQ.pollLast();
            maxQ.addLast(nums[right]);
            minQ.addLast(nums[right]);
            while (left <= right && maxQ.peekFirst() - minQ.peekFirst() > limit) {
                if (maxQ.peekFirst() == nums[left]) maxQ.pollFirst();
                if (minQ.peekFirst() == nums[left]) minQ.pollFirst();
                left++;
            }
            answer = Math.max(answer, right - left + 1);
        }
        return answer;
    }
}

