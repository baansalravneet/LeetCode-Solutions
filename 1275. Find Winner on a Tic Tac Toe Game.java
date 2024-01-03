class Solution {
    public String tictactoe(int[][] moves) {
        int[][] grid = getGrid(moves);
        for (int i = 0; i < 3; i++) {
            int sum = 0;
            for (int j = 0; j < 3; j++) {
                sum += grid[i][j];
            }
            if (sum == 3) return "A";
            else if (sum == -3) return "B";
        }
        for (int j = 0; j < 3; j++) {
            int sum = 0;
            for (int i = 0; i < 3; i++) {
                sum += grid[i][j];
            }
            if (sum == 3) return "A";
            else if (sum == -3) return "B";
        }
        int sum = grid[0][0] + grid[1][1] + grid[2][2];
        if (sum == 3) return "A";
        else if (sum == -3) return "B";

        sum = grid[0][2] + grid[1][1] + grid[2][0];
        if (sum == 3) return "A";
        else if (sum == -3) return "B";

        return moves.length == 9 ? "Draw" : "Pending";
    }

    private int[][] getGrid(int[][] moves) {
        int[][] result = new int[3][3];
        for (int i = 0; i < moves.length; i++) {
            result[moves[i][0]][moves[i][1]] = i%2==0 ? 1 : -1;
        }
        return result;
    }
}
