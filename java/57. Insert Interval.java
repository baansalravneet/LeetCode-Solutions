class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        boolean inserted = false;
        for (int[] i : intervals) {
            if (!inserted && newInterval[0] < i[0]) {
                checkedAppend(result, newInterval);
                inserted = true;
            }
            checkedAppend(result, i);
        }
        if (!inserted) checkedAppend(result, newInterval);
        int[][] answer = new int[result.size()][2];
        int pointer = 0;
        for (int[] i : result) answer[pointer++] = i;
        return answer;
    }
    private void checkedAppend(List<int[]> result, int[] newInterval) {
        if (result.isEmpty()) result.add(newInterval);
        else {
            int[] lastInterval = result.get(result.size()-1);
            if (overlapping(lastInterval, newInterval)) result.set(result.size()-1, merge(lastInterval, newInterval));
            else result.add(newInterval);
        }
    }
    private boolean overlapping(int[] a, int[] b) {
        return a[1] - a[0] + 1 + b[1] - b[0] + 1 > Math.max(a[1], b[1]) - Math.min(a[0], b[0]) + 1;
    }
    private int[] merge(int[] a, int[] b) {
        return new int[]{Math.min(a[0], b[0]), Math.max(a[1], b[1])};
    }
}
