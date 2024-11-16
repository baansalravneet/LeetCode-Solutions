class Solution {
    public boolean checkPartitioning(String s) {
        boolean[][] substring = getSubstring(s);
        Boolean[][] dp = new Boolean[s.length()][4];
        return helper(substring, 0, dp, 3, s.length());
    }
    private boolean helper
    (
        boolean[][] substring,
        int currentIndex,
        Boolean[][] dp,
        int remainingPartitions,
        int n
    )
    {
        if (currentIndex == n || remainingPartitions < 0) {
            if (remainingPartitions == 0) return true;
            return false;
        }
        if (dp[currentIndex][remainingPartitions] != null) return dp[currentIndex][remainingPartitions];
        boolean localAnswer = false;
        for (int i = currentIndex; i < n; i++) {
            if (substring[currentIndex][i]) {
                localAnswer = localAnswer || helper(substring, i+1, dp, remainingPartitions-1, n);
            }
            if (localAnswer) return localAnswer;
        }
        dp[currentIndex][remainingPartitions] = localAnswer;
        return localAnswer;
    }
    private boolean[][] getSubstring(String s) {
        int n = s.length();
        boolean[][] substring = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            substring[i][i] = true;
        }
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == s.charAt(i-1)) {
                substring[i-1][i] = true;
            }
        }
        for (int j = 2; j < n; j++) {
            int start = 0;
            int end = j;
            while (end < n) {
                substring[start][end] = s.charAt(start) == s.charAt(end) && substring[start+1][end-1];
                start++;
                end++;
            }
        }
        return substring;
    }
}
