class Solution {
    public int combinationSum4(int[] nums, int target) {
        Map<Integer, Integer> memo = new HashMap<>();
        return helper(memo, nums, target);
    }
    private int helper(Map<Integer, Integer> memo, int[] nums, int target) {
        if (target < 0) return 0;
        if (target == 0) return 1;
        if (memo.containsKey(target)) return memo.get(target);
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            count += helper(memo, nums, target - nums[i]);
        }
        memo.put(target, count);
        return count;
    }
}
