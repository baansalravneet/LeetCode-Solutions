class Solution {
    private static final int[][] directions = {
        {1,2}, {2,1}, {2,-1}, {1,-2},
        {-1,-2}, {-2,-1}, {-2,1}, {-1,2}
    };
    public double knightProbability(int n, int k, int row, int column) {
        if (k == 0) return 1;
        Double[][][] cache = new Double[n][n][k];
        return helper(n, row, column, k, 0, cache);
    } 
    private double helper(int n, int row, int col, int k, int moves, Double[][][] cache) {
        if (moves == k) {
            return Math.pow(0.125, moves);
        }
        if (cache[row][col][moves] != null) return cache[row][col][moves];
        double answer = 0;
        for (int[] next : directions) {
            int x = row + next[0];
            int y = col + next[1];
            if (x < 0 || x >= n || y < 0 || y >= n) continue;
            answer += helper(n, x, y, k, moves+1, cache);
        }
        return cache[row][col][moves] = answer;
    }
}

