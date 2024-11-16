class Solution {
    private static final int[][] directions = new int[][] {
        {-1,-1}, {-1,0}, {-1,1},
        {0,-1}, {0,1},
        {1,-1}, {1,0}, {1,1}
    };
    public int[][] imageSmoother(int[][] img) {
        int[][] result = new int[img.length][img[0].length];
        for (int i = 0; i < img.length; i++) {
            for (int j = 0; j < img[i].length; j++) {
                result[i][j] = change(img, i, j);
            }
        }
        return result;
    }
    private int change(int[][] img, int i, int j) {
        int count = 1;
        int sum = img[i][j];
        for (int[] d : directions) {
            if (i + d[0] < 0 || j + d[1] < 0) {
                continue;
            }
            if (i + d[0] >= img.length || j + d[1] >= img[0].length) {
                continue;
            }
            count++;
            sum += img[i+d[0]][j+d[1]];
        }
        return sum/count;
    }
}
