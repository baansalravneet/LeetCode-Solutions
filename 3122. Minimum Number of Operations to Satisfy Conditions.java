class Solution {
    public int minimumOperations(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] cost = new int[m][10];
        for (int j = 0; j < m; j++) {
            int[] freq = new int[10];
            for (int i = 0; i < n; i++) {
                freq[grid[i][j]]++;
            }
            for (int i = 0; i < 10; i++) {
                cost[j][i] = n-freq[i];
            }
        }
        Integer[][] cache = new Integer[m][11];
        return helper(cost, 0, 10, cache);
    }
    private int helper(int[][] cost, int current, int previous, Integer[][] cache) {
        if (current >= cost.length) return 0;
        if (cache[current][previous] != null) return cache[current][previous];
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            if (i == previous) continue;
            answer = Math.min(answer, cost[current][i] + helper(cost, current + 1, i, cache));
        }
        return cache[current][previous] = answer;
    }
}