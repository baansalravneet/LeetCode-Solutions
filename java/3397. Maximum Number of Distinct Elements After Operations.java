class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0, previous = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (previous < nums[i]-k) {
                count++;
                previous = nums[i]-k;
            } else if (previous >= nums[i]-k && nums[i]+k >= previous+1) {
                count++;
                previous++;
            }
        }
        return count;
    }
}

