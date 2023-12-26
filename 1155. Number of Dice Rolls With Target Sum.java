class Solution {
    private static final int MOD = 1_000_000_007;
    public int numRollsToTarget(int n, int k, int target) {
        Integer[][] dp = new Integer[n+1][target+1];
        return helper(n, k, target, dp);
    }

    private int helper(int n, int k, int target, Integer[][] dp) {
        if (target < 0) {
            return 0;
        }
        if (n == 0) {
            return target == 0 ? 1 : 0;
        }
        if (dp[n][target] != null) {
            return dp[n][target];
        }
        long answer = 0;
        for (int i = 1; i <= k; i++) {
            answer += helper(n-1, k, target-i, dp);
            answer %= MOD;
        }
        return dp[n][target] = (int)answer;
    }
}
