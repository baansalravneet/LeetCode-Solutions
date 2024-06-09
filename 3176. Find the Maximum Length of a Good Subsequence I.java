class Solution {
    public int maximumLength(int[] nums, int k) {
        int[][] dp = new int[nums.length][k+1];
        for (int[] x : dp) {
            Arrays.fill(x, 1);
        }
        int answer = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] == nums[j]) {
                    dp[i][0] = Math.max(dp[i][0], 1+dp[j][0]);
                }
            }
            answer = Math.max(answer, dp[i][0]);
        }
        for (int x = 1; x <= k; x++) {
            for (int i = 0; i < nums.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (nums[i] == nums[j]) {
                        dp[i][x] = Math.max(dp[i][x], 1+dp[j][x]);
                    } else {
                        dp[i][x] = Math.max(dp[i][x], 1+dp[j][x-1]);
                    }
                }
                answer = Math.max(answer, dp[i][x]);
            }
        }
        return answer;
    }
}
