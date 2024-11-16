class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] != 0 && i > 0) {
                    matrix[i][j] += matrix[i-1][j];
                }
            }
            int[] row = matrix[i].clone();
            Arrays.sort(row);
            for (int j = 0; j < m; j++) {
                answer = Math.max(answer, row[j] * (m-j));
            }
        }
        return answer;
    }
}
