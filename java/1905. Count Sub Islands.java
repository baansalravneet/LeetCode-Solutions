class Solution {
    private static final int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int count = 0;
        for (int i = 0; i < grid2.length; i++) {
            for (int j = 0; j < grid2[i].length; j++) {
                if (grid2[i][j] == 1) {
                    if (floodFill(grid2, grid1, i, j, true)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
    private boolean floodFill(int[][] grid2, int[][] grid1, int i, int j, boolean sub) {
        if (i < 0 || i >= grid2.length || j < 0 || j >= grid2[i].length || grid2[i][j] == 0) {
            return sub;
        }
        if (grid1[i][j] == 0) sub = false;
        grid2[i][j] = 0;
        for (int[] d : directions) {
            sub = floodFill(grid2, grid1, i+d[0], j+d[1], sub) && sub;
        }
        return sub;
    }
}
