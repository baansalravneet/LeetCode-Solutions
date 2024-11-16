class Solution {
    public int numDistinct(String s, String t) {
        Integer[][] dp = new Integer[s.length()][t.length()];
        return helper(s, t, 0, 0, dp);
    }
    private int helper(String s, String t, int i, int j,
                       Integer[][] dp) {
        if (j == t.length()) return 1;
        if (i == s.length()) return 0;
        if (dp[i][j] != null) return dp[i][j];
        if (s.charAt(i) != t.charAt(j)) {
            return dp[i][j] = helper(s, t, i+1, j, dp);
        }
        return dp[i][j] = helper(s, t, i+1, j+1, dp) + helper(s, t, i+1, j, dp);
    }
}
