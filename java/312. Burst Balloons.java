class Solution {
    public int maxCoins(int[] n) {
        int[] nums = new int[n.length + 2];
        nums[0] = 1;
        nums[nums.length-1] = 1;
        for (int i = 0; i < n.length; i++) {
            nums[i+1] = n[i];
        }
        Integer[][] dp = new Integer[nums.length][nums.length];
        return helper(nums, 1, nums.length - 2, dp);
    }
    private int helper(int[] nums, int left, int right, Integer[][] dp) {
        if (left > right) return 0;
        if (dp[left][right] != null) return dp[left][right];

        int localAnswer = Integer.MIN_VALUE;
        for (int i = left; i <= right; i++) {
            int current = nums[left - 1] * nums[i] * nums[right + 1];
            current += helper(nums, left, i-1, dp);
            current += helper(nums, i+1, right, dp);
            localAnswer = Math.max(localAnswer, current);
        }
        return dp[left][right] = localAnswer;
    }
}
