class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int left = 1, right = -1;
        for (int i : nums) {
            right = Math.max(right, i);
        }
        int answer = -1;
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
    private boolean isPossible(int[] nums, int maxOp, int maxVal) {
        int count = 0;
        for (int i : nums) {
            if (i <= maxVal) continue;
            count += i/maxVal;
            if (i % maxVal == 0) count--;
        }
        return count <= maxOp;
    }
}
