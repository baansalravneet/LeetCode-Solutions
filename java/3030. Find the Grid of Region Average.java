class Solution {
    public int[][] resultGrid(int[][] image, int threshold) {
        int n = image.length;
        int m = image[0].length;
        boolean[][] isRegion = new boolean[n-2][m-2];
        int[][] regionAverage = new int[n-2][m-2];
        for (int i = 0; i < n-2; i++) {
            loop: for (int j = 0; j < m-2; j++) {
                int sum = 0;
                for (int x = 0; x < 3; x++) {
                    sum += image[i][j+x];
                    sum += image[i+1][j+x];
                    sum += image[i+2][j+x];
                    if (Math.abs(image[i][j+x] - image[i+1][j+x]) > threshold) continue loop;
                    if (Math.abs(image[i+1][j+x] - image[i+2][j+x]) > threshold) continue loop;
                }
                for (int x = 0; x < 3; x++) {
                    if (Math.abs(image[i+x][j] - image[i+x][j+1]) > threshold) continue loop;
                    if (Math.abs(image[i+x][j+1] - image[i+x][j+2]) > threshold) continue loop;
                }
                isRegion[i][j] = true;
                regionAverage[i][j] = sum / 9;
            }
        }
        int[][] result = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int sum = 0;
                int count = 0;
                for (int x = i-2; x <= i; x++) {
                    for (int y = j-2; y <= j; y++) {
                        if (x < 0 || y < 0 || x >= n-2 || y >= m-2) continue;
                        if (isRegion[x][y]) {
                            count++;
                            sum += regionAverage[x][y];
                        }
                    }
                }
                if (count == 0) result[i][j] = image[i][j];
                else result[i][j] = sum / count;
            }
        }
        return result;
    }
}

