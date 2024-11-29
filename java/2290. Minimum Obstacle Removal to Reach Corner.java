class Solution {
    private static final int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    public int minimumObstacles(int[][] grid) {
        Deque<int[]> q = new LinkedList<>();
        int n = grid.length, m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        q.addFirst(new int[] {0, 0, 0});
        while (!q.isEmpty()) {
            int[] current = q.pollFirst();
            int x = current[0], y = current[1];
            if (x == n-1 && y == m-1) return current[2];
            if (visited[x][y]) continue;
            visited[x][y] = true;
            for (int[] d : directions) {
                int nx = x + d[0], ny = y + d[1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (visited[nx][ny]) continue;
                if (grid[nx][ny] == 1) {
                    q.addLast(new int[] {nx, ny, current[2] + 1});
                } else {
                    q.addFirst(new int[] {nx, ny, current[2]});
                }
            }
        }
        return -1;
    }
}