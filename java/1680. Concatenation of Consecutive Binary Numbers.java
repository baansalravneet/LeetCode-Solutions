class Solution {
    private static final long MOD = (long)1e9+7;
    public int concatenatedBinary(int n) {
        long answer = 0;
        int length = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & (i-1)) == 0) length++; // for example 111 to 1000
            answer = (answer << length) | i; // make space and add this number
            answer %= MOD;
        }
        return (int)answer;
    }
}

