class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        while (left < right) {
            if (nums[left] < nums[right]) {
                return nums[left];
            }
            int mid = (left + right)/2;
            if (nums[mid] < nums[left]) {
                right = mid;
            } else {
                left = mid+1;
            }
        }
        return nums[left];
    }
}

