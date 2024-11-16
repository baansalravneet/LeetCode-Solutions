class Solution {
    private static final int MOD = 1_000_000_007;
    public int maxSum(List<Integer> nums, int k) {
        int[] count = new int[32];
        for (int a : nums) {
            for (int i = 0; i < 32; i++) {
                if ((a & (1 << i)) != 0) {
                    count[i]++;
                }
            }
        }
        long result = 0;
        for (int index = 0; index < k; index++) {
            int current = 0;
            for (int i = 0; i < 32; i++) {
                if (count[i] > 0) {
                    count[i]--;
                    current += 1 << i;
                }
            }
            result += (((long)current * current) % MOD) % MOD;
            result %= MOD;
        }
        return (int)result;
    }
}
