class Solution {
    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
        long left = 0;
        long right = Long.MAX_VALUE;
        long answer = -1;
        Arrays.sort(workerTimes);
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (possible(workerTimes, mountainHeight, mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }
    private boolean possible(int[] arr, int h, long t) {
        for (int i = arr.length-1; i >= 0 && h >= 0; i--) {
            int time = arr[i];
            h -= getHeightLinear((long)time, t, h);
        }
        return h <= 0;
    }
    private long getHeightLinear(long workerTime, long totalTime, int h) {
        if (h <= 0) return 0;
        long height = 0;
        while (((height + 1)*(height + 2) / 2) * workerTime <= totalTime && height < h) {
            height++;
        }
        return height;
    }
    private long getHeight(long workerTime, long totalTime, int h) {
        if (h <= 0) return 0;
        long left = 0;
        long right = Long.MAX_VALUE;
        long answer = 0;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (((((mid)*(mid+1))/2)*workerTime) <= totalTime) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer;
    }
}