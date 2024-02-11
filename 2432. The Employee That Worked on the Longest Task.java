class Solution {
    public int hardestWorker(int n, int[][] logs) {
        int answer = Integer.MAX_VALUE;
        int maxTime = Integer.MIN_VALUE;
        int lastTime = 0;
        for (int i = 0; i < logs.length; i++) {
            int endTime = logs[i][1];
            if (endTime - lastTime == maxTime) {
                answer = Math.min(answer, logs[i][0]);
            } else if (endTime - lastTime > maxTime) {
                maxTime = endTime - lastTime;
                answer = logs[i][0];
            }
            lastTime = endTime;
        }
        return answer;
    }
}

