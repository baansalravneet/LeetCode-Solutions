class Solution {
    private static final int[][] directions = { {0,1}, {1,0}, {0,-1}, {-1,0} };
    public int minimumTime(int[][] grid) {
        if (grid[0][1] > 1 && grid[1][0] > 1) return -1;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        pq.add(new int[] {0, 0, 0});
        int n = grid.length, m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int x = current[0], y = current[1];
            if (x == n-1 && y == m-1) return current[2];
            if (visited[x][y]) continue;
            visited[x][y] = true;
            for (int[] d : directions) {
                int nx = x + d[0], ny = y + d[1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (visited[nx][ny]) continue;
                int diff = grid[nx][ny] - current[2];
                if (diff <= 1) pq.add(new int[] {nx, ny, current[2]+1});
                else {
                    int next = (diff/2)*2 + 1 + current[2];
                    pq.add(new int[] {nx, ny, next});
                }
            }
        }
        return -1;
    }
}