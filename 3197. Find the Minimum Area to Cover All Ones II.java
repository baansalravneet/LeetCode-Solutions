class Solution {
    public int minimumSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int answer = 10000;
        for (int i = 0; i < n-1; i++) {
            answer = Math.min(answer, findOne(grid, 0, 0, i, m-1) + findTwo(grid, i+1, 0, n-1, m-1));
            answer = Math.min(answer, findTwo(grid, 0, 0, i, m-1) + findOne(grid, i+1, 0, n-1, m-1));
        }
        for (int j = 0; j < m-1; j++) {
            answer = Math.min(answer, findOne(grid, 0, 0, n-1, j) + findTwo(grid, 0, j+1, n-1, m-1));
            answer = Math.min(answer, findTwo(grid, 0, 0, n-1, j) + findOne(grid, 0, j+1, n-1, m-1));
        }
        return answer;
    }
    private int findTwo(int[][] grid, int x1, int y1, int x2, int y2) {
        int answer = 10000;
        for (int x3 = x1; x3 < x2; x3++) {
            answer = Math.min(answer, findOne(grid, x1, y1, x3, y2) + findOne(grid, x3+1, y1, x2, y2));
        }
        for (int y3 = y1; y3 < y2; y3++) {
            answer = Math.min(answer, findOne(grid, x1, y1, x2, y3) + findOne(grid, x1, y3+1, x2, y2));
        }
        return answer;
    }
    private int findOne(int[][] grid, int x1, int y1, int x2, int y2) {
        int top = x2, bottom = x1, left = y2, right = y1;
        boolean found = false;
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                if (grid[i][j] == 1) {
                    found = true;
                    top = Math.min(top, i);
                    bottom = Math.max(bottom, i);
                    left = Math.min(left, j);
                    right = Math.max(right, j);
                }
            }
        }
        return found ? (bottom - top + 1) * (right - left + 1) : 10000;
    }
}
