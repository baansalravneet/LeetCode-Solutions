class Solution {
    private static final int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
    public int closedIsland(int[][] grid) {
        // 0 -> land
        // 1 -> water
        // change all the islands which are connected to the boundary
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] == 0) floodFill(grid, i, 0);
            if (grid[i][grid[0].length-1] == 0) floodFill(grid, i, grid[0].length-1);
        }
        for (int j = 0; j < grid[0].length; j++) {
            if (grid[0][j] == 0) floodFill(grid, 0, j);
            if (grid[grid.length-1][j] == 0) floodFill(grid, grid.length-1, j);
        }
        int answer = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    floodFill(grid, i, j);
                    answer++;
                }
            }
        }
        return answer;
    }
    private void floodFill(int[][] grid, int x, int y) {
        grid[x][y] = 2;
        for (int[] dir : directions) {
            int nx = x + dir[0], ny = y + dir[1];
            if (!onGrid(nx, ny, grid.length, grid[0].length)) continue;
            if (grid[nx][ny] != 0) continue;
            floodFill(grid, nx, ny);
        }
    }
    private boolean onGrid(int x, int y, int n, int m) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}
