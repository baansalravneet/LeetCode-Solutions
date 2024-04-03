class Solution {
    private static final int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (search(board, word, i, j, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }
    private boolean search(char[][] board, String word, int i, int j, int index, boolean[][] visited) {
        if (index == word.length()) return true;
        if (i < 0 || i >= board.length) return false;
        if (j < 0 || j >= board[0].length) return false;
        if (board[i][j] != word.charAt(index)) return false;
        if (visited[i][j]) return false;
        visited[i][j] = true;
        boolean answer = false;
        for (int[] dir : directions) {
            answer = answer || search(board, word, i + dir[0], j + dir[1], index+1, visited);
        }
        visited[i][j] = false;
        return answer;
    }
}
