class Solution {
    public int longestIdealString(String s, int k) {
        int[] dp = new int[26];
        int answer = 1;
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            int left = Math.max(0, c-k), right = Math.min(25, c+k);
            for (int j = left; j <= right; j++) {
                dp[c] = Math.max(dp[c], dp[j]);
            }
            dp[c] += 1;
            answer = Math.max(answer, dp[c]);
        }
        return answer;
    }
}