class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    floodFill(grid, i, j);
                }
            }
        }
        return count;
    }
    private void floodFill(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return;
        if (grid[i][j] == '0') return;
        grid[i][j] = '0';
        floodFill(grid, i+1, j);
        floodFill(grid, i-1, j);
        floodFill(grid, i, j+1);
        floodFill(grid, i, j-1);
    }
}