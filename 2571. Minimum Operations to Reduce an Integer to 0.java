class Solution {
    public int minOperations(int n) {
        int[] dp = new int[22];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i-1] * 2;
        }
        int answer = 0;
        while (n > 0) {
            int minDiff = Integer.MAX_VALUE;
            for (int i = 0; i < dp.length; i++) {
                minDiff = Math.min(minDiff, Math.abs(n - dp[i]));
            }
            n = minDiff;
            answer++;
        }
        return answer;
    }
}
