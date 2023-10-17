class Solution {
    public long maxPoints(int[][] points) {
        int n = points.length;
        int m = points[0].length;
        long[][] dp = new long[n][m];
        for (int i = 0; i < m; i++) {
            dp[0][i] = points[0][i];
        }
        for (int i = 1; i < n; i++) {
            long runningMax = dp[i-1][0];
            int index = 0;
            dp[i][0] = runningMax + points[i][0];
            for (int j = 1; j < m; j++) {
                if (dp[i-1][j] > runningMax - j + index) {
                    runningMax = dp[i-1][j];
                    index = j;
                }
                dp[i][j] = runningMax + points[i][j] - j + index;
            }
            runningMax = dp[i-1][m-1];
            index = m-1;
            dp[i][m-1] = Math.max(dp[i][m-1], runningMax + points[i][m-1]);
            for (int j = m-2; j >= 0; j--) {
                if (dp[i-1][j] > runningMax - index + j) {
                    runningMax = dp[i-1][j];
                    index = j;
                }
                dp[i][j] = Math.max(dp[i][j], runningMax + points[i][j] - index + j);
            }
        }
        return Arrays.stream(dp[n-1]).max().getAsLong();
    }
}
