class Solution {
    public int numberOfPairs(int[][] points) {
        int count = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i == j) continue;
                if (!checkPossible(points[i], points[j])) continue;
                int pointsBetween = 0;
                for (int k = 0; k < points.length; k++) {
                    if (k == i || k == j) continue;
                    if (pointsBetween > 0) break;
                    if (check(points[i], points[j], points[k])) {
                        pointsBetween++;
                    }
                }
                if (pointsBetween == 0) count++;
            }
        }
        return count/2;
    }
    private boolean checkPossible(int[] a, int[] b) {
        return (a[0] <= b[0] && a[1] >= b[1]) || (b[0] <= a[0] && b[1] >= a[1]);
    }
    private boolean check(int[] a, int[] b, int[] c) {
        return c[0] >= Math.min(a[0], b[0]) && c[0] <= Math.max(a[0], b[0]) &&
        c[1] >= Math.min(a[1], b[1]) && c[1] <= Math.max(a[1], b[1]);
    }
}