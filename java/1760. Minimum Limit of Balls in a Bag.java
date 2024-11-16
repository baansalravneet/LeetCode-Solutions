class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        Arrays.sort(nums);
        int left = 0;
        int right = -1;
        for (int i : nums) {
            right = Math.max(right, i);
        }
        int answer = right;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (isPossible(nums, maxOperations, mid)) {
                answer = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }
    private boolean isPossible(int[] nums, int maxOperations, int minimumValue) {
        for (int i = nums.length-1; i >= 0; i--) {
            if (minimumValue >= nums[i]) break;
            int breaks = (int)Math.ceil((double)nums[i]/minimumValue) - 1;
            if (breaks > maxOperations) return false;
            maxOperations -= breaks;
        }
        return true;
    }
}
