class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> {
            if (a[0] == b[0]) return b[1]-a[1];
            return a[0]-b[0];
        });
        int[] previous = intervals[0];
        int count = 1;
        for (int i = 1; i < intervals.length; i++) {
            int[] current = intervals[i];
            if (current[0] < previous[0] || current[1] > previous[1]) {
                previous = current;
                count++;
            }
        }
        return count;
    }
}
