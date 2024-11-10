class Solution {
    private static final int MOD = (int)1e9+7;
    public int numTilings(int n) {
        Integer[][] cache = new Integer[n+1][2];
        return (int)helper(n, 0, cache);
    }
    public long helper(int n, int previous, Integer[][] cache) {
        if (n < 1) return 0;
        if (n == 1) {
            if (previous != 0) return 0;
            return 1;
        }
        if (n == 2) {
            if (previous == 0) return 2;
            return 1;
        }

        if (cache[n][previous] != null) return cache[n][previous];
        long answer = 0;
        if (previous == 0) {
            answer += helper(n-1, 0, cache);
            answer %= MOD;
            answer += 2*helper(n-1, 1, cache);
            answer %= MOD;
            answer += helper(n-2, 0, cache);
            answer %= MOD;
        } else {
            answer += helper(n-1, 1, cache);
            answer %= MOD;
            answer += helper(n-2, 0, cache);
            answer %= MOD;
        }
        return cache[n][previous] = (int)answer;
    }
}