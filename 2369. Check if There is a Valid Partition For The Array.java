class Solution {
    public boolean validPartition(int[] nums) {
        Boolean[] cache = new Boolean[nums.length];
        return helper(nums, 0, cache);
    }
    private boolean helper(int[] nums, int index, Boolean[] cache) {
        if (index >= nums.length) return true;
        if (cache[index] != null) return cache[index];
        boolean answer = false;
        // check 1
        if (index+1 < nums.length && nums[index] == nums[index+1]) {
            answer = answer || helper(nums, index+2, cache);
        }
        // check 2
        if (index+2 < nums.length && nums[index] == nums[index+1] && nums[index] == nums[index+2]) {
            answer = answer || helper(nums, index+3, cache);
        }
        // check 3
        if (index+2 < nums.length && nums[index] == nums[index+1]-1 && nums[index] == nums[index+2]-2) {
            answer = answer || helper(nums, index+3, cache);
        }
        return cache[index] = answer;
    }
}
