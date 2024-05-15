class Solution {
    private static final int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        if (n == 1) return 0;
        if (grid.get(n-1).get(n-1) == 1 || grid.get(0).get(0) == 1) return 0;
        int[][] minDistances = findMin(grid);
        int left = 0;
        int right = grid.size();
        int answer = Integer.MIN_VALUE;
        boolean[][] visited = new boolean[grid.size()][grid.size()];
        while (left <= right) {
            int mid = (left + right) / 2;
            if (canDo(minDistances, mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }
    private int[][] findMin(List<List<Integer>> grid) {
        int n = grid.size();
        Deque<int[]> bfsQ = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    bfsQ.addLast(new int[] {i, j});
                }
            }
        }
        int[][] minDistance = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        int distance = 0;
        while (!bfsQ.isEmpty()) {
            int size = bfsQ.size();
            while (size-- > 0) {
                int[] current = bfsQ.pollFirst();
                if (visited[current[0]][current[1]]) continue;
                visited[current[0]][current[1]] = true;
                minDistance[current[0]][current[1]] = distance;
                for (int[] d: directions) {
                    int nextX = current[0] + d[0];
                    int nextY = current[1] + d[1];
                    if (nextX < 0 || nextX >= grid.size()) continue;
                    if (nextY < 0 || nextY >= grid.size()) continue;
                    if (visited[nextX][nextY]) continue;
                    bfsQ.addLast(new int[] {nextX, nextY});
                }
            }
            distance++;
        }
        return minDistance;
    }
    private boolean canDo(int[][] minDistances, int limit) {
        int n = minDistances.length;
        if (minDistances[0][0] < limit || minDistances[n-1][n-1] < limit) return false;
        Deque<int[]> bfsQ = new ArrayDeque<>();
        bfsQ.addLast(new int[] {0, 0});
        boolean[][] visited = new boolean[n][n];
        while (!bfsQ.isEmpty()) {
            int[] current = bfsQ.pollFirst();
            if (current[0] == n-1 && current[1] == n-1) return true;
            if (visited[current[0]][current[1]]) continue;
            visited[current[0]][current[1]] = true;
            for (int[] d : directions) {
                int nextX = current[0] + d[0];
                int nextY = current[1] + d[1];
                if (nextX < 0 || nextX >= n) continue;
                if (nextY < 0 || nextY >= n) continue;
                if (visited[nextX][nextY]) continue;
                if (minDistances[nextX][nextY] < limit) continue;
                bfsQ.addLast(new int[] {nextX, nextY});
            }
        }
        return false;
    }
}