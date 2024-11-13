class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        return count(nums, upper) - count(nums, lower-1);
    }
    private long count(int[] nums, int sum) {
        long answer = 0;
        int left = 0;
        int right = nums.length-1;
        while (left < right) {
            if (nums[left] + nums[right] <= sum) {
                answer += right - left;
                left++;
            } else {
                right--;
            }
        }
        return answer;
    }
}