class Solution {
    private static final int[][] directions = new int[][] {{1,0},{-1,0},{0,1},{0,-1}};
    private static final int MOD = 1_000_000_007;

    public int countPaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        long[][] dp = new long[m][n];
        long answer = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                answer += dfs(grid, i, j, dp, -1);
                answer %= MOD;
            }
        }
        return (int)answer;
    }
    private long dfs(int[][] grid, int i, int j, long[][] dp, int previous) {
        if (!valid(i, j, grid.length, grid[0].length)) return 0;
        if (grid[i][j] <= previous) return 0;
        if (dp[i][j] != 0) return dp[i][j];
        long count = 1;
        for (int[] d : directions) {
            count += dfs(grid, i+d[0], j+d[1], dp, grid[i][j]);
            count %= MOD;
        }
        dp[i][j] = count;
        return count;
    }
    private boolean valid(int i, int j, int m, int n) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }
}
