class Solution {
    private static final int MOD = 1000_000_007;
    public int countNicePairs(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = update(nums[i]);
        }
        Map<Integer, Integer> freq = new HashMap<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (freq.containsKey(nums[i])) {
                count += freq.get(nums[i]);
                count %= MOD;
            }
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }
        return count;
    }
    private int update(int i) {
        int a = i;
        int b = reverse(i);
        return a - b;
    }
    private int reverse(int i) {
        StringBuilder sb = new StringBuilder(String.valueOf(i));
        return Integer.parseInt(sb.reverse().toString());
    }
}
