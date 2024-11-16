class Solution {
    public int matrixScore(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[] rowFlips = new int[n];
        int[] colFlips = new int[m];
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 0) rowFlips[i]++;
        }
        for (int j = 1; j < m; j++) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                if ((grid[i][j]+rowFlips[i]) % 2 != 0) count++;
            }
            if (count <= n/2) colFlips[j]++;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = (grid[i][j] + rowFlips[i] + colFlips[j]) % 2;
            }
        }
        int answer = 0;
        for (int i = 0; i < n; i++) answer += getScore(grid[i]);
        return answer;
    }
    private int getScore(int[] arr) {
        int answer = 0;
        int current = 1;
        for (int i = arr.length-1; i >= 0; i--) {
            answer += arr[i] * current;
            current *= 2;
        }
        return answer;
    }
}