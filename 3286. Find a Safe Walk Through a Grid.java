class Solution {
    private static final int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int n = grid.size(), m = grid.get(0).size();
        Deque<int[]> pq = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        pq.addLast(new int[]{0,0,grid.get(0).get(0)});
        while (!pq.isEmpty()) {
            int[] current = pq.pollFirst();
            if (current[0] == n-1 && current[1] == m-1) return current[2] < health;
            if (current[2] >= health) continue;
            if (visited[current[0]][current[1]]) continue;
            visited[current[0]][current[1]] = true;
            for (int[] d : directions) {
                int x = current[0] + d[0];
                int y = current[1] + d[1];
                if (x < 0 || x >= n || y < 0 || y >= m) continue;
                if (visited[x][y]) continue;
                if (grid.get(x).get(y) == 1) {
                    pq.addLast(new int[]{x, y, current[2] + 1});
                } else {
                    pq.addFirst(new int[]{x, y, current[2]});
                }
            }
        }
        return false;
    }
}