class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        Set<Integer> banned = new HashSet<>();
        for (int[] i : mines) {
            banned.add(i[0] + n * i[1]);
        }
        int answer = 0;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                count = banned.contains(i + (n*j)) ? 0 : count+1;
                dp[i][j] = count;
            }
            count = 0;
            for (int j = n-1; j >= 0; j--) {
                count = banned.contains(i + (n*j)) ? 0 : count+1;
                dp[i][j] = Math.min(dp[i][j], count);
            }
        }
        for (int j = 0; j < n; j++) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                count = banned.contains(i + (n*j)) ? 0 : count+1;
                dp[i][j] = Math.min(dp[i][j], count);
            }
            count = 0;
            for (int i = n-1; i >= 0; i--) {
                count = banned.contains(i + (n*j)) ? 0 : count+1;
                dp[i][j] = Math.min(dp[i][j], count);
                answer = Math.max(dp[i][j], answer);
            }
        }
        return answer;
    }
}
