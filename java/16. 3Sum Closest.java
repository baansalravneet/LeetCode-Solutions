class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int left = i+1;
            int right = nums.length-1;
            while (left < right) {
                int current = nums[i] + nums[left] + nums[right];
                if (diff > Math.abs(current-target)) {
                    sum = current;
                    diff = Math.abs(current-target);
                } 
                if (current > target) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        return sum;
    }
}
