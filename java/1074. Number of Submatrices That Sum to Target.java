class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        getPrefix(matrix);
        int answer = 0;
        Map<Integer, Integer> count = new HashMap<>();
        for (int r1 = 0; r1 < matrix.length; r1++) {
            for (int r2 = r1; r2 < matrix.length; r2++) {
                count.clear();
                for (int c = 0; c < matrix[0].length; c++) {
                    int current = matrix[r2][c] - ((r1 > 0) ? matrix[r1-1][c] : 0);
                    if (current == target) answer++;
                    int diff = current - target;
                    if (count.containsKey(diff)) answer += count.get(diff);
                    count.put(current, count.getOrDefault(current, 0) + 1);
                }
            }
        }
        return answer;
    }
    private void getPrefix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int a = i > 0 ? matrix[i-1][j] : 0;
                int b = j > 0 ? matrix[i][j-1] : 0;
                int c = (i > 0 && j > 0) ? matrix[i-1][j-1] : 0;
                matrix[i][j] += a + b - c;
            }
        }
    }
}

