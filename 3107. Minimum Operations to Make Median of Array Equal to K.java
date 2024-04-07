class Solution {
    public long minOperationsToMakeMedianK(int[] nums, int k) {
        Arrays.sort(nums);
        int mid = nums.length / 2;
        long answer = 0;
        if (nums[mid] < k) {
            for (int i = mid; i < nums.length; i++) {
                if (nums[i] >= k) break;
                answer += k - nums[i];
            }
        } else if (nums[mid] > k) {
            for (int i = mid; i >= 0; i--) {
                if (nums[i] <= k) break;
                answer += nums[i] - k;
            }
        }
        return answer;
    }
}