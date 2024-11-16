class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int min1Index = -1;
        int min2Index = -1;
        for (int i = 0; i < n; i++) {
            if (grid[0][i] <= min2) {
                min2Index = i;
                min2 = grid[0][i];
            }
            if (grid[0][i] <= min1) {
                min2 = min1;
                min2Index = min1Index;
                min1 = grid[0][i];
                min1Index = i;
            }
        }
        for (int i = 1; i < n; i++) {
            int m1 = Integer.MAX_VALUE;
            int m2 = Integer.MAX_VALUE;
            int m1i = -1;
            int m2i = -1;
            for (int j = 0; j < n; j++) {
                int next = grid[i][j];
                if (j != min1Index) {
                    next += min1;
                } else {
                    next += min2;
                }
                if (next <= m2) {
                    m2i = j;
                    m2 = next;
                }
                if (next <= m1) {
                    m2 = m1;
                    m2i = m1i;
                    m1 = next;
                    m1i = j;
                }
            }
            min1 = m1;
            min1Index = m1i;
            min2 = m2;
            min2Index = m2i;
        }
        return min1;
    }
}