class Solution {
    private static final int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
    public int largestIsland(int[][] grid) {
        Map<Integer, Integer> sizes = new HashMap<>();
        int id = 2;
        int n = grid.length;
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int size = startDFS(grid, id, i, j);
                    answer = Math.max(answer, size);
                    sizes.put(id++, size);
                }
            }
        }
        if (sizes.isEmpty()) return 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> ids = new HashSet<>();
                    for (int[] d : directions) {
                        int ni = i + d[0];
                        int nj = j + d[1];
                        if (ni < 0 || ni >= n || nj < 0 || nj >= n) continue;
                        if (grid[ni][nj] == 0) continue;
                        ids.add(grid[ni][nj]);
                    }
                    if (ids.isEmpty()) continue;
                    int val = 0;
                    for (int x : ids) {
                        val += sizes.get(x);
                    }
                    answer = Math.max(answer, val+1);
                }
            }
        }
        return answer;
    }
    private int startDFS(int[][] grid, int id, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid.length) {
            return 0;
        }
        if (grid[i][j] == 0) return 0;
        if (grid[i][j] == id) return 0;
        grid[i][j] = id;
        int answer = 0;
        for (int[] d : directions) {
            int ni = i + d[0];
            int nj = j + d[1];
            answer += startDFS(grid, id, ni, nj);
        }
        return 1+answer;
    }
}
