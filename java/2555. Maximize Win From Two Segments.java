class Solution {
    public int maximizeWin(int[] prizePositions, int k) {
        int n = prizePositions.length;
        int answer = 0;
        int left = 0;
        int[] dp = new int[n];
        int result = 0;
        for (int right = 0; right < n; right++) {
            while (left < right && prizePositions[right] - prizePositions[left] > k) {
                left++;
            }
            answer = Math.max(answer, right - left + 1);
            dp[right] = answer;
            result = Math.max(result, right - left + 1 + (left > 0 ? dp[left-1] : 0));
        }
        return result;
    }
}
