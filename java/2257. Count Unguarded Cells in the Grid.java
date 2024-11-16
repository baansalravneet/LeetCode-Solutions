class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];
        for (int[] g : guards) {
            grid[g[0]][g[1]] = 1;
        }
        for (int[] g : walls) {
            grid[g[0]][g[1]] = 2;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; ) {
                if (grid[i][j] == 1) {
                    j++;
                    while (j < n && grid[i][j] != 2) {
                        grid[i][j] = grid[i][j] == 0 ? 3 : grid[i][j];
                        j++;
                    }
                } else {
                    j++;
                }
            }
            for (int j = n-1; j >= 0; ) {
                if (grid[i][j] == 1) {
                    j--;
                    while (j >= 0 && grid[i][j] != 2) {
                        grid[i][j] = grid[i][j] == 0 ? 3 : grid[i][j];
                        j--;
                    }
                } else {
                    j--;
                }
            }
        }
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; ) {
                if (grid[i][j] == 1) {
                    i++;
                    while (i < m && grid[i][j] != 2) {
                        grid[i][j] = grid[i][j] == 0 ? 3 : grid[i][j];
                        i++;
                    }
                } else {
                    i++;
                }
            }
            for (int i = m-1; i >= 0; ) {
                if (grid[i][j] == 1) {
                    i--;
                    while (i >= 0 && grid[i][j] != 2) {
                        grid[i][j] = grid[i][j] == 0 ? 3 : grid[i][j];
                        i--;
                    }
                } else {
                    i--;
                }
            }
        }
        int count = 0;
        for (int[] i : grid) {
            for (int j : i) {
                count += j == 0 ? 1 : 0;
            }
        }
        return count;
    }
}

