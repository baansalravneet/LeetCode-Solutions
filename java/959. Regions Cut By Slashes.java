class Solution {
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        boolean[][] expanded = new boolean[3*n][3*n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i].charAt(j) == '/') {
                    expanded[3*i+2][3*j] = true;
                    expanded[3*i+1][3*j+1] = true;
                    expanded[3*i][3*j+2] = true;
                } else if (grid[i].charAt(j) == '\\') {
                    expanded[3*i][3*j] = true;
                    expanded[3*i+1][3*j+1] = true;
                    expanded[3*i+2][3*j+2] = true;
                }
            }
        }
        int answer = 0;
        for (int i = 0; i < expanded.length; i++) {
            for (int j = 0; j < expanded.length; j++) {
                if (!expanded[i][j]) {
                    floodFill(expanded, i, j);
                    answer++;
                }
            }
        }
        return answer;
    }
    private void floodFill(boolean[][] arr, int i, int j) {
        if (i < 0 || i >= arr.length || j < 0 || j >= arr.length) return;
        if (arr[i][j]) return;
        arr[i][j] = true;
        floodFill(arr, i+1, j);
        floodFill(arr, i-1, j);
        floodFill(arr, i, j+1);
        floodFill(arr, i, j-1);
    }
}