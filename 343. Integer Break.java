class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        Arrays.fill(dp, Integer.MIN_VALUE);
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], j * (i-j));
                dp[i] = Math.max(dp[i], j * dp[i-j]);
            }
        }
        return dp[n];
    }
}
