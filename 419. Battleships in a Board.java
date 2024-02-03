class Solution {
    private static final int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    public int countBattleships(char[][] board) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X') {
                    count++;
                    floodFill(board, i, j);
                }
            }
        }
        return count;
    }
    private void floodFill(char[][] board, int x, int y) {
        if (x < 0 || x >= board.length) return;
        if (y < 0 || y >= board[0].length) return;
        if (board[x][y] == '.') return;
        board[x][y] = '.';
        for (int[] d : directions) {
            floodFill(board, x+d[0], y+d[1]);
        }
    }
}
