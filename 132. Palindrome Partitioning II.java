class Solution {
    public int minCut(String s) {
        boolean[][] substring = getSubstring(s);
        Integer[] dp = new Integer[s.length()];
        return helper(substring, dp, 0)-1;
    }
    private int helper(boolean[][] substring, Integer[] dp, int currentIndex) {
        if (currentIndex == substring.length) return 0;
        if (dp[currentIndex] != null) return dp[currentIndex];
        int localAnswer = Integer.MAX_VALUE;
        for (int i = currentIndex; i < substring.length; i++) {
            if (substring[currentIndex][i]) {
                localAnswer = Math.min(localAnswer, 1 + helper(substring, dp, i+1));
            }
        }
        dp[currentIndex] = localAnswer;
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
