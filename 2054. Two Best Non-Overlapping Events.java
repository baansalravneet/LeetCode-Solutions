class Solution {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events, (a,b) -> a[0] - b[0]);
        Integer[][] cache = new Integer[events.length][2];
        return helper(events, 0, 0, cache);
    }
    private int helper(int[][] events, int index, int chosen , Integer[][] cache) {
        if (index >= events.length) return 0;
        if (chosen >= 2) return 0;
        if (cache[index][chosen] != null) return cache[index][chosen];
        int value = events[index][2];
        return cache[index][chosen] = Math.max(
                value + helper(events, getNext(events, events[index][1]+1), chosen+1, cache),
                helper(events, index+1, chosen, cache)
        );
    }
    private int getNext(int[][] events, int minStart) {
        int left = 0;
        int right = events.length-1;
        int answer = events.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (events[mid][0] >= minStart) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }
}
