class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
            count++;
        }
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == s.charAt(i-1)) {
                dp[i-1][i] = true;
                count++;
            }
        }
        for (int length = 2; length <= n; length++) {
            for (int start = 0; start + length < n; start++) {
                if (s.charAt(start) == s.charAt(start+length) && dp[start+1][start+length-1]) {
                    dp[start][start+length] = true;
                    count++;
                }
            }
        }
        return count;
    }
}

