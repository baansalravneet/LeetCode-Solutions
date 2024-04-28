class Solution {
    public long numberOfRightTriangles(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] colOnes = new int[m];
        int[] rowOnes = new int[n];
        for (int i = 0; i < n; i++){
            int count = 0;
            for (int j = 0; j < m; j++) {
                count += grid[i][j];
            }
            rowOnes[i] = count;
        }
        for (int j = 0; j < m; j++) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                count += grid[i][j];
            }
            colOnes[j] = count;
        }
        long answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (colOnes[j] <= 1 || rowOnes[i] <= 1 || grid[i][j] == 0) continue;
                answer += (long)(colOnes[j]-1)*(rowOnes[i]-1);
            }
        }
        return answer;
    }
}