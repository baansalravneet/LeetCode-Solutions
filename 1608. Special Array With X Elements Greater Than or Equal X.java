class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length-1; i >= 0; i--) {
            int greater = nums.length-i;
            if (i > 0 && nums[i-1] < greater && nums[i] >= greater) {
                return greater;
            }
            if (i == 0 && nums[i] >= greater) {
                return greater;
            }
        }
        return -1;
    }
}
