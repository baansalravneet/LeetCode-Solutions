class Solution {
    public boolean placeWordInCrossword(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        // left to right
        boolean answer = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == ' ' || board[i][j] == word.charAt(0)) {
                    if (j == 0 || board[i][j-1] == '#') {
                        if (tryLeftToRight(board, i, j, word)) return true;
                    }
                }
            }
            for (int j = m-1; j >= 0; j--) {
                if (board[i][j] == ' ' || board[i][j] == word.charAt(0)) {
                    if (j == m-1 || board[i][j+1] == '#') {
                        if (tryRightToLeft(board, i, j, word)) return true;
                    }
                }
            }
        }
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                if (board[i][j] == ' ' || board[i][j] == word.charAt(0)) {
                    if (i == 0 || board[i-1][j] == '#') {
                        if (tryTopToBottom(board, i, j, word)) return true;
                    }
                }
            }
            for (int i = n-1; i >= 0; i--) {
                if (board[i][j] == ' ' || board[i][j] == word.charAt(0)) {
                    if (i == n-1 || board[i+1][j] == '#') {
                        if (tryBottomToTop(board, i, j, word)) return true;
                    }
                }
            }
        }
        return false;
    }
    private boolean tryLeftToRight(char[][] board, int i, int j, String word) {
        for (char c : word.toCharArray()) {
            if (j >= board[i].length) return false;
            if (board[i][j] != ' ' && board[i][j] != c) return false;
            j++;
        }
        if (j < board[i].length && board[i][j] != '#') return false;
        return true;
    }
    private boolean tryRightToLeft(char[][] board, int i, int j, String word) {
        for (char c : word.toCharArray()) {
            if (j < 0) return false;
            if (board[i][j] != ' ' && board[i][j] != c) return false;
            j--;
        }
        if (j >= 0 && board[i][j] != '#') return false;
        return true;
    }
    private boolean tryTopToBottom(char[][] board, int i, int j, String word) {
        for (char c : word.toCharArray()) {
            if (i >= board.length) return false;
            if (board[i][j] != ' ' && board[i][j] != c) return false;
            i++;
        }
        if (i < board.length && board[i][j] != '#') return false;
        return true;
    }
    private boolean tryBottomToTop(char[][] board, int i, int j, String word) {
        for (char c : word.toCharArray()) {
            if (i < 0) return false;
            if (board[i][j] != ' ' && board[i][j] != c) return false;
            i--;
        }
        if (i >= 0 && board[i][j] != '#') return false;
        return true;
    }
}
