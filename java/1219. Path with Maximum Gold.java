class Solution {
    private static final int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
    public int getMaximumGold(int[][] grid) {
        int answer = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != 0) answer = Math.max(answer, dfs(grid, i, j));
            }
        }
        return answer;
    }
    private int dfs(int[][] grid, int currX, int currY) {
        int temp = grid[currX][currY];
        int answer = 0;
        grid[currX][currY] = 0;
        for (int[] d : directions) {
            int nextX = currX + d[0];
            int nextY = currY + d[1];
            if (nextX < 0 || nextX >= grid.length) continue;
            if (nextY < 0 || nextY >= grid[0].length) continue;
            if (grid[nextX][nextY] == 0) continue;
            answer = Math.max(answer, dfs(grid, nextX, nextY));
        }
        grid[currX][currY] = temp;
        return temp + answer;
    }
}