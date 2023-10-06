class Solution {

    private static final int[][] directions = new int[][] {{1,0},
                                                           {-1,0},
                                                           {0,1},
                                                           {0,-1}};
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int answer = Integer.MIN_VALUE;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                answer = Math.max(answer, helper(matrix, i, j, dp, -1));
            }
        }

        return answer;
    }

    private int helper(int[][] matrix, int curX, int curY, int[][] dp, int previous) {
        if (valid(curX, curY, matrix.length, matrix[0].length)) return 0;
        if (matrix[curX][curY] <= previous) return 0;
        if (dp[curX][curY] != 0) return dp[curX][curY];

        int answer = 1;
        for (int[] d : directions) {
            answer = Math.max(answer, 1 + helper(matrix, curX + d[0], curY + d[1], dp, matrix[curX][curY]));
        }
        return dp[curX][curY] = answer;
    }

    private boolean valid(int i, int j, int m, int n) {
        return i < 0 || i >= m || j < 0 || j >= n;
    }
}
