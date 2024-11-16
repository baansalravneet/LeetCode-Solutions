class Solution {
    public int[] resultsArray(int[] nums, int k) {
        if (k == 1) return nums;
        int[] result = new int[nums.length-k+1];
        int left = 0;
        for (int right = 1; right < nums.length; right++) {
            if (nums[right] != nums[right-1]+1) {
                while (left < nums.length-k+1 && left != right) {
                    result[left++] = -1;
                }
            }
            if (right - left + 1 == k) {
                result[left++] = nums[right];
            }
        }
        return result;
    }
}
