class Solution {
    private static final int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length, m = moveTime[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        pq.add(new int[]{0, 0, 0});
        boolean[][] visited = new boolean[n][m];
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            if (current[0] == n-1 && current[1] == m-1) return current[2];
            if (visited[current[0]][current[1]]) continue;
            visited[current[0]][current[1]] = true;
            for (int[] d : directions) {
                int x = current[0] + d[0];
                int y = current[1] + d[1];
                if (x < 0 || x >= n || y < 0 || y >= m) continue;
                if (visited[x][y]) continue;
                int cost = Math.max(current[2], moveTime[x][y]) + 1;
                pq.add(new int[]{x,y,cost});
            }
        }
        return -1;
    }
}