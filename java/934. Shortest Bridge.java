class Solution {
    private static final int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Deque<int[]> bfsQ = new LinkedList<>();
        OUTER:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    floodFill(grid, i, j, bfsQ);
                    break OUTER;
                }
            }
        }
        return bfs(grid, bfsQ)-1;
    }
    private void floodFill(int[][] grid, int i, int j, Deque<int[]> bfsQ) {
        if (grid[i][j] != 1) return;
        grid[i][j] = 2;
        bfsQ.addFirst(new int[] {i, j});
        for (int[] dir : directions) {
            int nx = dir[0] + i, ny = dir[1] + j;
            if (onGrid(nx, ny, grid.length, grid[0].length) && grid[nx][ny] == 1) {
                floodFill(grid, nx, ny, bfsQ);
            }
        }
    }
    private int bfs(int[][] grid, Deque<int[]> bfsQ) {
        int answer = 0;
        while (!bfsQ.isEmpty()) {
            int size = bfsQ.size();
            while (size-- > 0) {
                int[] current = bfsQ.pollLast();
                for (int[] dir : directions) {
                    int nx = dir[0] + current[0];
                    int ny = dir[1] + current[1];
                    if (!onGrid(nx, ny, grid.length, grid[0].length)) continue;
                    if (grid[nx][ny] == 2) continue;
                    if (grid[nx][ny] == 1) return answer;
                    grid[nx][ny] = 2;
                    bfsQ.addFirst(new int[] {nx, ny});
                }
            }
            answer++;
        }
        return answer;
    }
    private boolean onGrid(int x, int y, int n, int m) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}


