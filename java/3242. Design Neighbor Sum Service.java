class neighborSum {
    private int[][] grid;
    private Map<Integer, int[]> positions;
    private static int[][] adDir = {{1,0},{-1,0},{0,1},{0,-1}};
    private static int[][] diDir = {{-1,-1},{1,-1},{-1,1},{1,1}};

    public neighborSum(int[][] grid) {
        this.grid = grid;
        positions = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                positions.put(grid[i][j], new int[]{i, j});
            }
        }
    }
    
    public int adjacentSum(int value) {
        int[] p = positions.get(value);
        int x = p[0], y = p[1];
        return getAnswer(x, y, adDir);
    }
    
    public int diagonalSum(int value) {
        int[] p = positions.get(value);
        int x = p[0], y = p[1];
        return getAnswer(x, y, diDir);
    }

    private int getAnswer(int x, int y, int[][] dir) {
        int answer = 0;
        for (int[] d : dir) {
            int nx = x+d[0], ny = y+d[1];
            if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid.length) {
                answer += grid[nx][ny];
            }
        }
        return answer;
    }
}

/**
 * Your neighborSum object will be instantiated and called as such:
 * neighborSum obj = new neighborSum(grid);
 * int param_1 = obj.adjacentSum(value);
 * int param_2 = obj.diagonalSum(value);
 */