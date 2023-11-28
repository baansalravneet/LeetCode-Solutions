class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[] flatBoard = flatBoard(board, n);
        Deque<Integer> bfsQ = new ArrayDeque<>();
        bfsQ.addLast(1);
        int count = 0;
        boolean[] visited = new boolean[n*n];
        while (!bfsQ.isEmpty()) {
            int size = bfsQ.size();
            while (size-- > 0) {
                int current = bfsQ.pollFirst();
                for (int i = current+1; i <= n*n && i <= current+6; i++) {
                    int next = i;
                    if (flatBoard[i-1] != -1) next = flatBoard[i-1];
                    if (next == n*n) return count+1;
                    if (visited[next-1]) continue;
                    visited[next-1] = true;
                    bfsQ.addLast(next);
                }
            }
            count++;
        }
        return -1;
    }
    private int[] flatBoard(int[][] board, int n) {
        boolean forward = true;
        int[] result = new int[n*n];
        int index = 0;
        for (int i = n-1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (forward) result[index++] = board[i][j];
                else result[index++] = board[i][n-1-j];
            }
            forward = !forward;
        }
        return result;
    }
}
