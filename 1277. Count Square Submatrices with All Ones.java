class Solution {
    public int countSquares(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int answer = 0;
        int[][] cache = new int[n][m];
        for (int[] i : cache) Arrays.fill(i, -1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                answer += solve(i, j, matrix, cache);
            }
        }
        return answer;
    }
    private int solve(int i, int j, int[][] matrix, int[][] cache) {
        if (i >= matrix.length || j >= matrix[0].length) return 0;
        if (matrix[i][j] == 0) return 0;
        if (cache[i][j] != -1) return cache[i][j];
        int right = solve(i, j+1, matrix, cache);
        int diagonal = solve(i+1, j+1, matrix, cache);
        int down = solve(i+1, j, matrix, cache);
        return cache[i][j] = 1 + Math.min(right, Math.min(diagonal, down));
    }
}