class Solution {
    public long minCost(int n, int[][] cost) {
        Long[][][] cache = new Long[n][4][4];
        return findCost(n, cost, 0, 0, 0, cache);
    }
    private long findCost(
        int n,
        int[][] cost,
        int idx,
        int left,
        int right,
        Long[][][] cache
    )
    {
        if (idx >= n/2) return 0;
        long answer = Long.MAX_VALUE;
        if (cache[idx][left][right] != null) return cache[idx][left][right];
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                if (i == left || j == right || i == j) continue;
                long val = findCost(idx+1, i, j)
                if (val != Long.MAX_VALUE) {
                    answer = Math.min(answer, cost[idx][i-1] + cost[n-1-idx][j-1] + val);
                }
            }
        }
        return cache[idx][left][right] = answer;
    }
}