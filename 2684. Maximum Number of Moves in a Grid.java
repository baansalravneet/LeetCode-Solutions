class Solution {
    public int maxMoves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] cache = new int[n][m];
        for (int[] i: cache) {
            Arrays.fill(i, -1);
        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, find(grid, i, 0, cache));
        }
        return answer;
    }
    private int find(int[][] grid, int i, int j, int[][] cache) {
        if (cache[i][j] != -1) return cache[i][j];
        int answer = 0;
        if (j+1 < grid[0].length && grid[i][j] < grid[i][j+1]) {
            answer = Math.max(answer, 1+find(grid, i, j+1, cache));
        }
        if (j+1 < grid[0].length && i+1 < grid.length && grid[i][j] < grid[i+1][j+1]) {
            answer = Math.max(answer, 1+find(grid, i+1, j+1, cache));
        }
        if (i-1 >= 0 && j+1 < grid[0].length && grid[i][j] < grid[i-1][j+1]) {
            answer = Math.max(answer, 1+find(grid, i-1, j+1, cache));
        }
        return cache[i][j] = answer;
    }
}
