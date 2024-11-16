class Solution {
    public int sumOfBeauties(int[] nums) {
        int n = nums.length;
        int largestLeft = nums[0];
        int[] smallestRight = new int[n];
        smallestRight[n-1] = nums[n-1];
        for (int i = n-2; i >= 0; i--) {
            smallestRight[i] = Math.min(nums[i], smallestRight[i+1]);
        }
        int count = 0;
        for (int i = 1; i < n-1; i++) {
            if (nums[i] > largestLeft && nums[i] < smallestRight[i+1]) {
                count += 2;
            } else if (nums[i] > nums[i-1] && nums[i] < nums[i+1]) {
                count += 1;
            }
            largestLeft = Math.max(largestLeft, nums[i]);
        }
        return count;
    }
}
