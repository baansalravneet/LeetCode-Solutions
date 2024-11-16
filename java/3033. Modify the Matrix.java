class Solution {
    public int[][] modifiedMatrix(int[][] matrix) {
        int[] colMax = new int[matrix[0].length];
        Arrays.fill(colMax, Integer.MIN_VALUE);
        for (int j = 0; j < matrix[0].length; j++) {
            for (int i = 0; i < matrix.length; i++) {
                colMax[j] = Math.max(colMax[j], matrix[i][j]);
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == -1) matrix[i][j] = colMax[j];
            }
        }
        return matrix;
    }
}

