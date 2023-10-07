class Solution {
    public int numOfArrays(int n, int m, int k) {
        Long[][][] dp = new Long[n+1][m+1][k+1];
        return (int)helper(0, 0, 0, n, m, k, dp);
    }
    private long helper(int length, int lenLIS, int maxVal, int n, int m, int k, Long[][][] dp) {
        if (lenLIS > k) return 0;
        if (maxVal < lenLIS) return 0;
        if (length >= n) {
            return lenLIS == k ? 1 : 0;
        }
        if (dp[length][maxVal][lenLIS] != null) return dp[length][maxVal][lenLIS];
        long answer = 0;
        for (int i = 1; i <= m; i++) {
            if (i > maxVal) {
                answer += helper(length + 1, lenLIS + 1, i, n, m, k, dp);
            } else {
                answer += helper(length + 1, lenLIS, maxVal, n, m, k, dp);
            }
            answer %= 1_000_000_007;
        }
        return dp[length][maxVal][lenLIS] = answer;
    }
}
