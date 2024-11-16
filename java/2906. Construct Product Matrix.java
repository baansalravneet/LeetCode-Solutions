class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] answer = new int[n][m];
        long running = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                answer[i][j] = (int)running;
                running *= grid[i][j];
                running %= 12345;
            }
        }
        running = 1;
        for (int i = n-1; i >= 0; i--) {
            for (int j = m-1; j >= 0; j--) {
                long current = answer[i][j];
                current *= running;
                current %= 12345;
                answer[i][j] = (int)current;
                running *= grid[i][j];
                running %= 12345;
            }
        }
        return answer;
    }
}
