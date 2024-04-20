class Solution {
    private static final int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
    public int[][] findFarmland(int[][] land) {
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (land[i][j] == 1) {
                    result.add(findEndpoints(land, i, j));
                }
            }
        }
        return result.toArray(new int[result.size()][]);
    }

    private int[] findEndpoints(int[][] land, int row, int col) {
        int i = row, j = col;
        while (i < land.length && land[i][col] == 1) i++;
        while (j < land[0].length && land[row][j] == 1) j++;
        for (int x = row; x < i; x++) {
            for (int y = col; y < j; y++) {
                land[x][y] = 0;
            }
        }
        return new int[] {row, col, i-1, j-1};
    }
}
