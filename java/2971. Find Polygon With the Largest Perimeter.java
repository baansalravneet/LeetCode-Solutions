class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        long sum = 0;
        for (int i : nums) {
            sum += i;
        }
        for (int i = nums.length-1; i >= 0; i++) {
            if (nums[i] >= sum - nums[i]) {
                sum -= nums[i];
            } else {
                return sum;
            }
        }
        return -1;
    }
}

