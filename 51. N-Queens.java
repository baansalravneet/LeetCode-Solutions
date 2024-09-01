class Solution {
    public List<List<String>> solveNQueens(int n) {
        boolean[][] board = new boolean[n][n];
        List<List<String>> result = new ArrayList<>();
        helper(board, result, 0);
        return result;
    }
    private void helper(boolean[][] board, List<List<String>> result, int row) {
        if (row >= board.length) {
            result.add(getAnswer(board));
            return;
        }
        for (int i = 0; i < board.length; i++) {
            if (canPlace(board, row, i)) {
                board[row][i] = true;
                helper(board, result, row+1);
                board[row][i] = false;
            }
        }
    }
    private boolean canPlace(boolean[][] board, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (board[i][col]) return false;
        }
        for (int i = row-1, j = col-1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j]) return false;
        }
        for (int i = row-1, j = col+1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j]) return false;
        }
        return true;
    }
    private List<String> getAnswer(boolean[][] board) {
        List<String> result = new ArrayList<>();
        for (boolean[] row : board) {
            StringBuilder sb = new StringBuilder();
            for (boolean b : row) {
                sb.append(b ? "Q" : ".");
            }
            result.add(sb.toString());
        }
        return result;
    }
}