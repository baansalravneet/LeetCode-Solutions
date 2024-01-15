class Solution {
    public long countSubarrays(int[] nums, long k) {
        long[] prefix = new long[nums.length];
        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i-1] + nums[i];
        }
        int left = 0;
        long answer = 0;
        for (int right = 0; right < nums.length; right++) {
            long current = prefix[right] - (left > 0 ? prefix[left-1] : 0);
            current *= right-left+1;
            while (current >= k && left <= right) {
                current = prefix[right]-prefix[left];
                left++;
                current *= right-left+1;
            }
            answer += right-left+1;
        }
        return answer;
    }
}

