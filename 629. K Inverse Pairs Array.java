class Solution {
    private static final int MOD = (int)1e9+7;
    public int kInversePairs(int n, int k) {
        Integer[][] cache = new Integer[n+1][k+1];
        return helper(n, k, cache);
    }
    private int helper(int n, int k, Integer[][] cache) {
        if (n == 0) {
            return k == 0 ? 1 : 0;
        }
        if (cache[n][k] != null) return cache[n][k];
        long answer = 0;
        for (int i = 0; i <= Math.min(n-1, k); i++) {
            answer += helper(n-1, k-i, cache);
            answer %= MOD;
        }
        return cache[n][k] = (int)answer;
    }
}

