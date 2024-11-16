class Solution {
    private static int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    public int minDays(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if (findComponents(grid, n, m) != 1) return 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) continue;
                grid[i][j] = 0;
                if (findComponents(grid, n, m) != 1) return 1;
                grid[i][j] = 1;
            }
        }
        return 2;
    }
    private int findComponents(int[][] grid, int n, int m) {
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0 || grid[i][j] == 2) continue;
                floodFill(grid, n, m, i, j);
                answer++;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) grid[i][j] = 1;
            }
        }
        return answer;
    }
    private void floodFill(int[][] grid, int n, int m, int i, int j) {
        if (i < 0 || i >= n || j < 0 || j >= m) return;
        if (grid[i][j] == 0 || grid[i][j] == 2) return;
        grid[i][j] = 2;
        for (int[] d : directions) {
            floodFill(grid, n, m, i+d[0], j+d[1]);
        }
    }
}