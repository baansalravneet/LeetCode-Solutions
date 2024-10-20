class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int maxOr = 0;
        for (int i : nums) maxOr |= i;
        return count(nums, 0, maxOr, 0);
    }
    private int count(int[] nums, int currentOr, int maxOr, int index) {
        if (index == nums.length) return currentOr == maxOr ? 1 : 0;
        return count(nums, currentOr, maxOr, index+1) + count(nums, currentOr | nums[index], maxOr, index+1);
    }
}