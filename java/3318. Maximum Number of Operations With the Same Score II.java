class Solution {
    public int maxOperations(int[] nums) {
        int answer = 0;
        Integer[][] cache = new Integer[nums.length][nums.length];
        answer = Math.max(answer,helper(nums, 0, nums.length-1, nums[0]+nums[1], cache));
        cache = new Integer[nums.length][nums.length];
        answer = Math.max(answer,helper(nums, 0, nums.length-1, nums[0]+nums[nums.length-1], cache));
        cache = new Integer[nums.length][nums.length];
        answer = Math.max(answer,helper(nums, 0, nums.length-1, nums[nums.length-2]+nums[nums.length-1], cache));
        return answer;
    }
    private int helper(int[] nums, int left, int right, int sum, Integer[][] cache) {
        if (left >= right) return 0;
        if (cache[left][right] != null) return cache[left][right];
        int answer = 0;
        if (nums[left] + nums[left+1] == sum) {
            answer = Math.max(answer, 1 + helper(nums, left+2, right, sum, cache));
        }
        if (nums[left] + nums[right] == sum) {
            answer = Math.max(answer, 1 + helper(nums, left+1, right-1, sum, cache));
        }
        if (nums[right] + nums[right-1] == sum) {
            answer = Math.max(answer, 1 + helper(nums, left, right-2, sum, cache));
        }
        return cache[left][right] = answer;
    }
}
