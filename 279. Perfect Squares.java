class Solution {
    public int numSquares(int n) {
        Long[] cache = new Long[n+1];
        return (int)helper(n, cache);
    }
    private long helper(int n, Long[] cache) {
        if (n <= 1) return n;
        if (cache[n] != null) return cache[n];
        long answer = Integer.MAX_VALUE;
        for (int i = 1; i*i <= n; i++) {
            answer = Math.min(answer, 1 + helper(n-i*i, cache));
        }
        return cache[n] = answer;
    }
}
