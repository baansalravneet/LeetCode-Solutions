class Solution {
    public int minDistance(int[] houses, int k) {
        Arrays.sort(houses);
        Integer[][] cache = new Integer[k+1][houses.length];
        return helper(houses, k, 0, cache);
    }
    private int helper(int[] houses, int remainingGroups, int index, Integer[][] cache) {
        if (index >= houses.length) {
            if (remainingGroups == 0) {
                return 0;
            } else {
                return (int)1e8;
            }
        }
        if (remainingGroups < 0) return (int)1e8;
        if (cache[remainingGroups][index] != null) return cache[remainingGroups][index];
        int answer = Integer.MAX_VALUE;
        for (int i = index; i < houses.length; i++) {
            answer = Math.min(
                    answer,
                    makeGroup(houses, index, i) + helper(houses, remainingGroups - 1, i+1, cache)
            );
        }
        return cache[remainingGroups][index] = answer;
    }
    private int makeGroup(int[] houses, int left, int right) {
        int median = houses[(left + right)/2];
        int answer = 0;
        for (int i = left; i <= right; i++) {
            answer += Math.abs(houses[i] - median);
        }
        return answer;
    }
}
