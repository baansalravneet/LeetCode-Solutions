class Solution {
    public int integerBreak(int n) {
        if (n <= 2) return 1;
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        Arrays.fill(dp, Integer.MIN_VALUE);
        for (int i = 3; i <= n; i++) {
            for (int j = 2; j <= 3; j++) {
                dp[i] = Math.max(dp[i], j * (i-j));
                dp[i] = Math.max(dp[i], j * dp[i-j]);
            }
        }
        return dp[n];
    }
}
