class Solution {
    public boolean predictTheWinner(int[] nums) {
        Integer[][][] cache = new Integer[nums.length][nums.length][2];
        int score = helper(nums, 0, nums.length-1, 0, cache);
        return score >= 0;
    }

    private int helper(int[] nums, int left, int right, int player, Integer[][][] cache) {
        if (left > right) {
            return 0;
        }
        if (cache[left][right][player] != null) {
            return cache[left][right][player];
        }
        if (player == 1) {
            int score = -nums[left]+helper(nums, left+1, right, 1-player, cache);
            score = Math.min(score, -nums[right]+helper(nums, left, right-1, 1-player, cache));
            return score;
        } else {
            int score = nums[left]+helper(nums, left+1, right, 1-player, cache);
            score = Math.max(score, nums[right]+helper(nums, left, right-1, 1-player, cache));
            return score;
        }
    }
}
