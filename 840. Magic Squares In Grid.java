class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        if (grid.length < 3 || grid[0].length < 3) return 0;
        int answer = 0;
        for (int i = 0; i < grid.length-2; i++) {
            for (int j = 0; j < grid.length-2; j++) {
                answer += check(grid, i, j) ? 1 : 0;
            }
        }
        return answer;
    }
    private boolean check(int[][] grid, int i, int j) {
        boolean[] seen = new boolean[10];
        for (int x = i; x < i+3; x++) {
            for (int y = j; y < j+3; y++) {
                if (grid[x][y] > 9 || grid[x][y] < 1) return false;
                if (seen[grid[x][y]]) return false;
                seen[grid[x][y]] = true;
            }
        }
        int sum = grid[i][j] + grid[i+1][j] + grid[i+2][j];
        if (sum != grid[i][j+1] + grid[i+1][j+1] + grid[i+2][j+1]) return false;
        if (sum != grid[i][j+2] + grid[i+1][j+2] + grid[i+2][j+2]) return false;
        if (sum != grid[i][j] + grid[i][j+1] + grid[i][j+2]) return false;
        if (sum != grid[i+1][j] + grid[i+1][j+1] + grid[i+1][j+2]) return false;
        if (sum != grid[i+2][j] + grid[i+2][j+1] + grid[i+2][j+2]) return false;
        if (sum != grid[i][j] + grid[i+1][j+1] + grid[i+2][j+2]) return false;
        if (sum != grid[i+2][j] + grid[i+1][j+1] + grid[i][j+2]) return false;
        return true;
    }
}