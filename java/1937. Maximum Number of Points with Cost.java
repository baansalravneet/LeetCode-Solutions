class Solution {
    public long maxPoints(int[][] points) {
        int n = points.length;
        int m = points[0].length;
        long[][] dp = new long[n][m];
        for (int i = 0; i < m; i++) {
            dp[0][i] = points[0][i];
        }
        for (int i = 1; i < n; i++) {
            long runningMaxLeft = dp[i-1][0], runningMaxRight = dp[i-1][m-1];
            for (int left = 0, right = m-1; left < m && right >= 0; left++, right--) {
                runningMaxLeft = Math.max(dp[i-1][left], runningMaxLeft-1);
                runningMaxRight = Math.max(dp[i-1][right], runningMaxRight-1);
                dp[i][left] = Math.max(dp[i][left], points[i][left] + runningMaxLeft);
                dp[i][right] = Math.max(dp[i][right], points[i][right] + runningMaxRight);
            }
        }
        return Arrays.stream(dp[n-1]).max().getAsLong();
    }
}

