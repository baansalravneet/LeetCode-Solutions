class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] prefix = new long[n+1];
        for (int i = 0; i < n; i++) {
            prefix[i+1] = prefix[i] + nums[i];
        }
        Deque<Integer> monoq = new LinkedList<>();
        int answer = n + 1;
        for (int i = 0; i <= n; i++) {
            while (!monoq.isEmpty() && prefix[i] - prefix[monoq.peekFirst()] >= k) {
                answer = Math.min(answer, i - monoq.pollFirst());
            }
            while (!monoq.isEmpty() && prefix[i] <= prefix[monoq.peekLast()]) {
                monoq.pollLast();
            }
            monoq.addLast(i);
        }
        return answer <= n ? answer : -1;
    }
}