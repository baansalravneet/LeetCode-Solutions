class Solution {
    private static final int MOD = (int)(1e9) + 7;
    public int countPathsWithXorValue(int[][] grid, int k) {
        int n = grid.length, m = grid[0].length;
        int[][][] dp = new int[n][m][16];
        dp[0][0][grid[0][0]] = 1;
        for (int i = 1; i < n; i++) {
            setNewState(dp[i][0], dp[i-1][0], grid[i][0]);
        }
        for (int j = 1; j < m; j++) {
            setNewState(dp[0][j], dp[0][j-1], grid[0][j]);
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                setNewState(dp[i][j], dp[i-1][j], grid[i][j]);
                setNewState(dp[i][j], dp[i][j-1], grid[i][j]);
            }
        }
        return dp[n-1][m-1][k];
    }
    private void setNewState(int[] current, int[] old, int value) {
        for (int i = 0; i < 16; i++) {
            current[i ^ value] += old[i];
            current[i ^ value] %= MOD;
        }
    }
}

