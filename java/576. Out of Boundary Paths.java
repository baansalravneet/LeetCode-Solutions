class Solution {
    private static final int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
    private static final int MOD = (int)1e9+7;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        Integer[][][] cache = new Integer[m][n][maxMove+1];
        return helper(startRow, startColumn, m, n, maxMove, cache);
    }
    private int helper(int currentRow,
                       int currentCol,
                       int m,
                       int n,
                       int movesLeft,
                       Integer[][][] cache) {
        if (currentRow < 0 || currentRow >= m || currentCol < 0 || currentCol >= n) {
            return 1;
        }
        if (movesLeft == 0) return 0;
        if (cache[currentRow][currentCol][movesLeft] != null) {
            return cache[currentRow][currentCol][movesLeft];
        }
        long answer = 0;
        for (int[] d : directions) {
            answer += helper(currentRow + d[0], currentCol + d[1], m, n, movesLeft - 1, cache);
        }
        return cache[currentRow][currentCol][movesLeft] = (int)(answer%MOD);
    }
}
