class Solution {
    private static char[] vowels = new char[] {'a','e','i','o','u'};
    private static int MOD = 1000000007;
    public int countVowelPermutation(int n) {
        long answer = 0;
        Long[][] dp = new Long[n+1][26];
        for (char c : vowels) {
            answer += helper(n-1, c, dp);
            answer %= MOD;
        }
        return (int)answer;
    }
    private long helper(int n, char previous, Long[][] dp) {
        if (n == 0) return 1;
        if (dp[n][previous-'a'] != null) return dp[n][previous-'a'];
        if (previous == 'a') {
            dp[n][previous-'a'] = helper(n-1, 'e', dp);
        } else if (previous == 'e') {
            dp[n][previous-'a'] = helper(n-1, 'a', dp) + helper(n-1, 'i', dp);
        } else if (previous == 'i') {
            dp[n][previous-'a'] = helper(n-1, 'a', dp) + helper(n-1, 'e', dp) + helper(n-1, 'o', dp) + helper(n-1, 'u', dp);
        } else if (previous == 'o') {
            dp[n][previous-'a'] = helper(n-1, 'i', dp) + helper(n-1, 'u', dp);
        } else if (previous == 'u') {
            dp[n][previous-'a'] = helper(n-1, 'a', dp);
        }
        return dp[n][previous-'a'] = dp[n][previous-'a'] % MOD;
    }
}
