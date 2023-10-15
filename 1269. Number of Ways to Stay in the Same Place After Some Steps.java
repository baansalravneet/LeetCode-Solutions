class Solution {
    private static final int MOD = 1_000_000_007;
    public int numWays(int steps, int arrLen) {
        int bound = Math.min(steps, arrLen);
        Integer[][] dp = new Integer[bound+1][steps+1];
        return (int)helper(0, steps, arrLen, dp, bound);
    }
    private long helper
    (
        int current,
        int steps,
        int arrLen,
        Integer[][] dp,
        int bound
    )
    {
        if (current < 0 || current >= arrLen) return 0;
        if (current < 0 || current > bound) return 0;
        if (steps < 0) return 0;
        if (current > steps) return 0;
        if (current == 0 && steps == 0) return 1;
        if (dp[current][steps] != null) return dp[current][steps];
        
        
        long answer = helper(current+1, steps-1, arrLen, dp, bound);
        answer += helper(current-1, steps-1, arrLen, dp, bound);
        answer += helper(current, steps-1, arrLen, dp, bound);
        answer %= MOD;
        dp[current][steps] = (int)answer;
        return answer;
    }
}
