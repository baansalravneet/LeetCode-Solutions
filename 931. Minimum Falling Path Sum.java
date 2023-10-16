class Solution {
    public int minFallingPathSum(int[][] matrix) {
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int current = matrix[i-1][j];
                if (j > 0) {
                    current = Math.min(current, matrix[i-1][j-1]);
                }
                if (j < matrix[i].length-1) {
                    current = Math.min(current, matrix[i-1][j+1]);
                }
                matrix[i][j] = current + matrix[i][j];
            }
        }
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < matrix[0].length; i++) {
            answer = Math.min(answer, matrix[matrix.length-1][i]);
        }
        return answer;
    }
}
