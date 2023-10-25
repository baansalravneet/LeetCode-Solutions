class Solution {
    public int minimumChanges(String s, int k) {
        int[][] minChanges = findMinChanges(s);
        for (int[] i : minChanges) {
            for (int j : i) {
                System.out.print(j+ " ");
            }
            System.out.println();
        }
        Integer[][] dp = new Integer[s.length()][k+1];
        return helper(minChanges, dp, 0, k);
    }
    private int helper
    (
        int[][] minChanges,
        Integer[][] dp,
        int currentIndex,
        int remainingPartitions
    )
    {
        if (currentIndex == minChanges.length || remainingPartitions < 0) {
            if (remainingPartitions == 0) return 0;
            return Integer.MAX_VALUE;
        }
        if (dp[currentIndex][remainingPartitions] != null) return dp[currentIndex][remainingPartitions];
        int localAnswer = Integer.MAX_VALUE;
        for (int i = currentIndex+1; i < minChanges.length; i++) {
            int current = minChanges[currentIndex][i];
            int next = helper(minChanges, dp, i+1, remainingPartitions-1);
            if (next != Integer.MAX_VALUE) {
                localAnswer = Math.min(localAnswer, current + next);
            }
        }
        return dp[currentIndex][remainingPartitions] = localAnswer;
    }
    private int[][] findMinChanges(String s) {
        int n = s.length();
        int[][] minChanges = new int[n][n];
        for (int start = 0; start < n; start++) {
            for (int end = start + 1; end < n; end++) {
                minChanges[start][end] = find(s, start, end);
            }
        }
        return minChanges;
    }
    private int find(String s, int start, int end) {
        int length = end - start + 1;
        int minCost = length;
        for (int d = 1; d < length; d++) {
            if (length % d != 0) continue;
            int cost = 0;
            for (int i = 0; i < d; i++) {
                int st = start + i;
                int en = end + 1 - d + i;
                while (st < en) {
                    if (s.charAt(st) != s.charAt(en)) cost++;
                    st += d;
                    en -= d;
                }
            }
            minCost = Math.min(cost, minCost);
        }
        return minCost;
    }
}
