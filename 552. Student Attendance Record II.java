class Solution {
    private static final int MOD = (int)1e9 + 7;
    public int checkRecord(int n) {
        Integer[][][] cache = new Integer[n][2][3];
        return find(n, 0, 0, 0, cache);
    }
    private int find(int n, int length, int countA, int previousLates, Integer[][][] cache) {
        if (countA >= 2 || previousLates >= 3) return 0;
        if (length >= n) return 1;
        if (cache[length][countA][previousLates] != null) {
            return cache[length][countA][previousLates];
        }
        long answer = 0;
        answer += find(n, length+1, countA+1, 0, cache);
        answer %= MOD;
        answer += find(n, length+1, countA, 0, cache);
        answer %= MOD;
        answer += find(n, length+1, countA, previousLates+1, cache);
        answer %= MOD;
        return cache[length][countA][previousLates] = (int)answer;
    }
}