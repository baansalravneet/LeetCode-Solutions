class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long[] preSum = new long[n];
        preSum[0] = nums[0] % k;
        for (int i = 1; i < n; i++) {
            preSum[i] = (long)nums[i] + preSum[i-1];
            preSum[i] %= k;
            if (preSum[i] == 0 && i >= 1) return true;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey((int)preSum[i])) {
                if (i - map.get((int)preSum[i]) >= 2) return true;
            } else {
                map.put((int)preSum[i], i);
            }
        }
        return false;
    }
}
