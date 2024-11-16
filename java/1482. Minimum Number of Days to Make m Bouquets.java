class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        long right = Integer.MIN_VALUE;
        long left = Integer.MAX_VALUE;
        for (int i : bloomDay) {
            right = Math.max(right, i);
            left = Math.min(left, i);
        }
        int answer = -1;
        while (left <= right) {
            long mid = (left + right)/2;
            if (canDo(bloomDay, m, k, (int)mid)) {
                answer = (int)mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }
    private boolean canDo(int[] n, int m, int k, int currentDay) {
        int count = 0;
        int currentWindow = 0;
        for (int i : n) {
            if (i <= currentDay) {
                currentWindow++;
            } else {
                currentWindow = 0;
            }
            if (currentWindow == k) {
                count++;
                currentWindow = 0;
            }
        }
        return count >= m;
    }
}
