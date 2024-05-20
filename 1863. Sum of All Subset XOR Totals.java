class Solution {
    public int subsetXORSum(int[] nums) {
        return sum(nums, 0, 0);
    }
    private int sum(int[] nums, int index, int current) {
        if (index >= nums.length) return current;
        return sum(nums, index+1, current)
            + sum(nums, index+1, current ^ nums[index]);
    }
}