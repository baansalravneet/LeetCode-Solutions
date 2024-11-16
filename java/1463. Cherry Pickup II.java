class Solution {
    public int cherryPickup(int[][] grid) {
        Integer[][][] cache = new Integer[grid.length][grid[0].length][grid[0].length];
        return helper(grid, 0, 0, grid[0].length-1, cache);
    }
    private int helper(int[][] grid, int r, int c1, int c2, Integer[][][] cache) {
        if (r == grid.length) return 0;
        if (c1 < 0 || c1 == grid[0].length) return 0;
        if (c2 < 0 || c2 == grid[0].length) return 0;
        if (cache[r][c1][c2] != null) return cache[r][c1][c2];
        int answer = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                answer = Math.max(answer, helper(grid, r+1, c1+i, c2+j, cache));
            }
        }
        if (c1 == c2) answer += grid[r][c1];
        else answer += grid[r][c1] + grid[r][c2];
        return cache[r][c1][c2] = answer;
    }
}
