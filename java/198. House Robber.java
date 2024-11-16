class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int prev = Math.max(nums[1], nums[0]);
        int prevprev = nums[0];
        for (int i = 2; i < nums.length; i++) {
            int current = Math.max(nums[i] + prevprev, prev);
            prevprev = prev;
            prev = current;
        }
        return Math.max(prev, prevprev);
    }
}

