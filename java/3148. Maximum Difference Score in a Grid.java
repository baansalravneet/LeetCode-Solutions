class Solution {
    public int maxScore(List<List<Integer>> grid) {
        int n = grid.size();
        int m = grid.get(0).size();
        int[][] mins = new int[n][m];
        mins[0][0] = grid.get(0).get(0);
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) continue;
                if (j == 0) {
                    answer = Math.max(answer, grid.get(i).get(0) - mins[i-1][0]);
                    mins[i][0] = Math.min(mins[i-1][0], grid.get(i).get(0));
                } else if (i == 0) {
                    answer = Math.max(answer, grid.get(0).get(j) - mins[0][j-1]);
                    mins[0][j] = Math.min(mins[0][j-1], grid.get(0).get(j));
                } else {
                    answer = Math.max(answer, grid.get(i).get(j) - mins[i-1][j]);
                    answer = Math.max(answer, grid.get(i).get(j) - mins[i][j-1]);
                    mins[i][j] = Math.min(mins[i-1][j], mins[i][j-1]);
                    mins[i][j] = Math.min(mins[i][j], grid.get(i).get(j));
                }
            }
        }
        return answer;
    }
}