class Solution {
    public int minSteps(int n) {
        if (n == 1) return 0;
        Integer[][] cache = new Integer[n][n];
        return 1 + helper(1, 1, n, cache);
    }
    private int helper(int current, int buffer, int n, Integer[][] cache) {
        if (current == n) return 0;
        if (current + buffer > n) return 10000;
        if (cache[current][buffer] != null) return cache[current][buffer];
        return cache[current][buffer] = Math.min(
            1 + helper(current+buffer, buffer, n, cache),
            2 + helper(current+current, current, n, cache)
        );
    }
}
