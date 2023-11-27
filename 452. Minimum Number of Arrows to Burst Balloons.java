class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a,b) -> {
            if (a[1] > b[1]) return 1;
            else return -1;
        });
        int count = 0;
        int i = 0;
        while (i < points.length) {
            int end = points[i][1];
            count++;
            while (i < points.length && points[i][0] <= end) i++;
        }
        return count;
    }
}
