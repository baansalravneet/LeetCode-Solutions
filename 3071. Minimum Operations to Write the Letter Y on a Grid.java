class Solution {
    public int minimumOperationsToWriteY(int[][] grid) {
        int y0 = checkY(grid, 0);
        int y1 = checkY(grid, 1);
        int y2 = checkY(grid, 2);
        int ny0 = checkNotY(grid, 0);
        int ny1 = checkNotY(grid, 1);
        int ny2 = checkNotY(grid, 2);
        int answer = y0 + ny1;
        answer = Math.min(answer, y0 + ny2);
        answer = Math.min(answer, y1 + ny0);
        answer = Math.min(answer, y1 + ny2);
        answer = Math.min(answer, y2 + ny0);
        answer = Math.min(answer, y2 + ny1);
        return answer;
    }
    private int checkY(int[][] grid, int value) {
        int count = 0;
        int n = grid.length;
        for (int i = 0; i < n/2; i++) {
            if (grid[i][i] != value) count++;
            if (grid[i][n-1-i] != value) count++;
            if (grid[n/2+i+1][n/2] != value) count++;
        }
        if (grid[n/2][n/2] != value) count++;
        return count;
    }
    private int checkNotY(int[][] grid, int value) {
        int count = 0;
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j && i < n/2) continue;
                if (i == n-1-j && i < n/2) continue;
                if (i >= n/2 && j == n/2) continue;
                if (grid[i][j] != value) count++;
            }
        }
        return count;
    }
}

