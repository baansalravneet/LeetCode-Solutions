class Solution {
    public long minEnd(int n, int x) {
        long answer = (long)x;
        long num = n - 1;
        for (int i = 0; i < 64 && num > 0; i++) {
            if (((long)x & (1L << i)) == 0) {
                if (num % 2L == 1L) {
                    answer = answer | (1L << i);
                }
                num /= 2L;
            }
        }
        return answer;
    }
}