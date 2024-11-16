class Solution {
    public int cherryPickup(int[][] grid) {
        Integer[][][][] cache = new Integer[grid.length][grid.length][grid.length][grid.length];
        return Math.max(helper(grid, 0, 0, 0, 0, grid.length, cache), 0);
    }
    private int helper(int[][] grid, int r1, int c1, int r2, int c2, int n, Integer[][][][] cache) {
        if (r1 == n || r2 == n || c1 == n || c2 == n) return Integer.MIN_VALUE;
        if (grid[r1][c1] == -1 || grid[r2][c2] == -1) return Integer.MIN_VALUE;
        if (r1 == n-1 && c1 == n-1) return grid[r1][c1];
        if (cache[r1][c1][r2][c2] != null) return cache[r1][c1][r2][c2];
        int answer = 0;
        if (r1 == r2 && c1 == c2) answer = grid[r1][c1];
        else answer = grid[r1][c1] + grid[r2][c2];
        answer += Math.max(
                Math.max(
                        helper(grid, r1+1, c1, r2+1, c2, n, cache),
                        helper(grid, r1+1, c1, r2, c2+1, n, cache)
                ),
                Math.max(
                        helper(grid, r1, c1+1, r2+1, c2, n, cache),
                        helper(grid, r1, c1+1, r2, c2+1, n, cache)
                )
        );
        return cache[r1][c1][r2][c2] = answer;
    }
}
