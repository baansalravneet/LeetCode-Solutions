class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (!q.isEmpty() && i - q.peekFirst() > k) {
                q.pollFirst();
            }
            dp[i] = (q.isEmpty() ? 0 : dp[q.peekFirst()]) + nums[i];
            while (!q.isEmpty() && dp[q.peekLast()] < dp[i]) {
                q.pollLast();
            }
            if (dp[i] > 0) q.addLast(i);
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}
