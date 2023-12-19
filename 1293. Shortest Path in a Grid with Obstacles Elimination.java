class Solution {
    private static final int[][] directions = new int[][] {
        {-1, 0}, {1,0}, {0,1}, {0,-1}
    };
    public int shortestPath(int[][] grid, int k) {
        if (k >= grid.length + grid[0].length - 2) return grid.length + grid[0].length - 2;
        Deque<int[]> bfsq = new ArrayDeque<>();
        bfsq.addLast(new int[]{0, 0, k, 0});
        int[][] visited = new int[grid.length][grid[0].length];
        for (int[] arr : visited) {
            Arrays.fill(arr, Integer.MIN_VALUE);
        }
        while (!bfsq.isEmpty()) {
            int[] current = bfsq.pollFirst();
            if (current[0] == grid.length-1 && current[1] == grid[0].length-1) {
                return current[3];
            }
            if (visited[current[0]][current[1]] >= current[2]) {
                continue;
            }
            visited[current[0]][current[1]] = current[2];
            for (int[] d : directions) {
                int x = current[0] + d[0];
                int y = current[1] + d[1];
                if (x < 0 || y < 0) {
                    continue;
                }
                if (x >= grid.length || y >= grid[0].length) {
                    continue;
                }
                if (grid[x][y] == 1 && current[2] <= 0) {
                    continue;
                }
                if (grid[x][y] == 1) {
                    bfsq.addLast(new int[]{x, y, current[2]-1, current[3]+1});
                } else {
                    bfsq.addLast(new int[]{x, y, current[2], current[3]+1});
                }
            }
        }
        return -1;
    }
}
