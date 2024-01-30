class Solution {
    public int longestArithSeqLength(int[] nums) {
        if (nums.length == 2) return 2;
        int[][] dp = new int[nums.length][1001];
        int answer = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                int diff = nums[j] - nums[i] + 500;
                dp[i][diff] = 1 + dp[j][diff];
                answer = Math.max(answer, dp[i][diff]);
            }
        }
        return answer + 1;
    }
}
