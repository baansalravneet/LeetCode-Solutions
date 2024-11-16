class Solution {
    public int countSubmatrices(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        for (int i = 1; i < n; i++) grid[i][0] += grid[i-1][0];
        for (int j = 1; j < m; j++) grid[0][j] += grid[0][j-1];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                grid[i][j] += grid[i-1][j] + grid[i][j-1] - grid[i-1][j-1];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] <= k) count++;
            }
        }
        return count;
    }
}
