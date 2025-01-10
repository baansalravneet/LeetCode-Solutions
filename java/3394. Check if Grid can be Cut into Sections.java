class Solution {
    public boolean checkValidCuts(int n, int[][] rectangles) {
        List<int[]> xDir = new ArrayList<>();
        List<int[]> yDir = new ArrayList<>();
        for (int[] rect : rectangles) {
            xDir.add(new int[] {rect[0], rect[2]});
            yDir.add(new int[] {rect[1], rect[3]});
        }
        return count(xDir) >= 3 || count(yDir) >= 3;
    }
    private int count(List<int[]> intervals) {
        Collections.sort(intervals, (a,b) -> a[0]-b[0]);
        int count = 0;
        int maxEnd = -1;
        for (int i = 0; i < intervals.size(); ) {
            maxEnd = intervals.get(i)[1];
            count++;
            while (i < intervals.size() && intervals.get(i)[0] < maxEnd) {
                maxEnd = Math.max(maxEnd, intervals.get(i)[1]);
                i++;
            }
        }
        return count;
    }
}

