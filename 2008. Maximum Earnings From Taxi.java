class Solution {
    public long maxTaxiEarnings(int n, int[][] rides) {
        Arrays.sort(rides, (a,b) -> a[0] - b[0]);
        Long[] cache = new Long[rides.length];
        return helper(rides, 0, cache);
    }
    private long helper(int[][] rides, int index, Long[] cache) {
        if (index >= rides.length) return 0;
        if (cache[index] != null) return cache[index];
        long answer = -1;
        int profit = rides[index][1] - rides[index][0] + rides[index][2];
        int nextRide = findNextRide(rides, rides[index][1]);
        return cache[index] = Math.max(
                profit + helper(rides, nextRide, cache),
                helper(rides, index+1, cache)
        );
    }
    private int findNextRide(int[][] rides, int minStart) {
        int left = 0;
        int right = rides.length-1;
        int answer = rides.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (rides[mid][0] >= minStart) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }
}

