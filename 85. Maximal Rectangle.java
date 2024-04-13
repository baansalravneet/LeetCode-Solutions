class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] histograms = new int[n][m];
        for (int j = 0; j < m; j++) {
            histograms[0][j] = matrix[0][j] == '1' ? 1 : 0;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                histograms[i][j] = matrix[i][j] == '0' ? 0 : histograms[i-1][j] + 1;
            }
        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, find(histograms[i]));
        }
        return answer;
    }
    private int find(int[] histogram) {
        Deque<Integer> stack = new ArrayDeque<>();
        int answer = 0;
        int i = 0;
        for (; i < histogram.length; i++) {
            while (!stack.isEmpty() && histogram[i] <= histogram[stack.peekLast()]) {
                int height = histogram[stack.pollLast()];
                if (stack.isEmpty()) answer = Math.max(answer, i * height);
                else answer = Math.max(answer, (i-stack.peekLast()-1) * height);
            }
            stack.addLast(i);
        }
        while (!stack.isEmpty()) {
            int height = histogram[stack.pollLast()];
            if (stack.isEmpty()) answer = Math.max(answer, i * height);
            else answer = Math.max(answer, (i-stack.peekLast()-1) * height);
        }
        return answer;
    }
}