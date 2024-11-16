class Solution {
    private static final int[][] directions = {
        {1,1}, {1,0}, {1,-1}, {-1,1},
        {-1,0}, {-1,-1}, {0,1}, {0,-1},
    };
    public void gameOfLife(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int count = findAlive(board, i, j);
                if (board[i][j] == 1) {
                    if (count < 2 || count > 3) {
                        board[i][j] = 3;
                    }
                } else {
                    if (count == 3) {
                        board[i][j] = 2;
                    }
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 3) board[i][j] = 0;
                else if (board[i][j] == 2) board[i][j] = 1;
            }
        }
    }
    private int findAlive(int[][] board, int i, int j) {
        int count = 0;
        for (int[] d : directions) {
            int x = i + d[0], y = j + d[1];
            if (x < 0 || x >= board.length) continue;
            if (y < 0 || y >= board[0].length) continue;
            if (board[x][y] == 1 || board[x][y] == 3) count++;
        }
        return count;
    }
}