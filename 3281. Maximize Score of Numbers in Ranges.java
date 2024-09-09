class Solution {
    public int maxPossibleScore(int[] start, int d) {
        Arrays.sort(start);
        int n = start.length;
        int left = 0;
        int right = start[n-1] - start[0] + d;
        int answer = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (check(start, d, mid)) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }
    private boolean check(int[] start, long d, long m) {
        long previous = start[0];
        for (int i = 1; i < start.length; i++) {
            if ((long)start[i] + d < previous + m) return false;
            previous = Math.max(start[i], previous + m);
        }
        return true;
    }
}


