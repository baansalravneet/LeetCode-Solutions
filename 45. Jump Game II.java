class Solution {
    public int jump(int[] nums) {
        Integer[] cache = new Integer[nums.length];
        return helper(nums, 0, cache);
    }
    private int helper(int[] nums, int index, Integer[] cache) {
        if (index == nums.length-1) return 0;
        if (nums[index] == 0) return Integer.MAX_VALUE;
        if (cache[index] != null) return cache[index];
        long answer = Integer.MAX_VALUE;
        for (int i = 1; i <= nums[index] && index+i < nums.length; i++) {
            answer = Math.min(answer, 1L + helper(nums, index+i, cache));
        }
        return cache[index] = (int)answer;
    }
}