class Solution {
    public boolean canMakeSquare(char[][] grid) {
        int[][] directions = new int[][]{{0, 0}, {0, 1}, {1, 0}, {1, 1}};
        for (int[] d : directions) {
            int i = d[0], j = d[1];
            int count = 0;
            for (int[] d1 : directions) {
                int x = d1[0], y = d1[1];
                if (grid[i+x][j+y] == 'B') count++;
            }
            if (count != 2) return true;
        }
        return false;
    }
}