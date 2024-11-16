class Solution {
    public boolean satisfiesConditions(int[][] grid) {
        for (int j = 0; j < grid[0].length; j++) {
            if (j != 0 && grid[0][j-1] == grid[0][j]) return false;
            for (int i = 0; i < grid.length; i++) {
                if (i != 0 && grid[i][j] != grid[i-1][j]) return false;
            }
        }
        return true;
    }
}