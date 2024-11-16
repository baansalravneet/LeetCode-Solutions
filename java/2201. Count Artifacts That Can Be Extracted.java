class Solution {
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        int[][] digArray = new int[n][n];
        for (int[] i : dig) {
            digArray[i[0]][i[1]] = 1;
        }
        int count = 0;
        for (int[] art : artifacts) {
            if (isDug(art, digArray)) count++;
        }
        return count;
    }
    private boolean isDug(int[] art, int[][] arr) {
        for (int i = art[0]; i <= art[2]; i++) {
            for (int j = art[1]; j <= art[3]; j++) {
                if (arr[i][j] != 1) return false;
            }
        }
        return true;
    }
}
