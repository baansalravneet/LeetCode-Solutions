class Solution {
    private static int[][] d = {{0,1},{1,0},{0,-1},{-1,0}};
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] answer = new int[rows * cols][2];
        answer[0][0] = rStart;
        answer[0][1] = cStart;
        if (rows * cols == 1) return answer;
        int length = 1, dir = 0;
        int[] pos = {rStart, cStart};
        int index = 1;
        LOOP: while (true) {
            for (int i = 0; i < length; i++) {
                pos[0] += d[dir][0];
                pos[1] += d[dir][1];
                if (check(pos, rows, cols)) {
                    answer[index][0] = pos[0];
                    answer[index++][1] = pos[1];
                    if (index == answer.length) break LOOP;
                }
            }
            dir = (dir+1)%4;
            if (dir % 2 == 0) length++;
        }
        return answer;
    }
    private boolean check(int[] pos, int rows, int cols) {
        return pos[0] >= 0 && pos[0] < rows && pos[1] >= 0 && pos[1] < cols;
    }
}
