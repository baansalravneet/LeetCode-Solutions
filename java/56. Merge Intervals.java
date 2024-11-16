class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        List<int[]> answer = new ArrayList<>();
        answer.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] current = intervals[i];
            int[] previous = answer.get(answer.size()-1);
            if (previous[1] >= current[0]) {
                previous[1] = Math.max(current[1], previous[1]);
            } else {
                answer.add(current);
            }
        }
        int[][] result = new int[answer.size()][2];
        for (int i = 0; i < result.length; i++) {
            result[i] = answer.get(i);
        }
        return result;
    }
}
