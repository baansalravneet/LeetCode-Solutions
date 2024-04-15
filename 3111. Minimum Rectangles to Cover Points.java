class Solution {
    public int minRectanglesToCoverPoints(int[][] points, int w) {
        Arrays.sort(points, (a,b) -> a[0] - b[0]);
        int answer = 0;
        int previousEnd = -1;
        for (int i = 0; i < points.length; i++) {
            int start = points[i][0];
            if (start > previousEnd) {
                answer++;
                previousEnd = start + w;
            }
        }
        return answer;
    }
}