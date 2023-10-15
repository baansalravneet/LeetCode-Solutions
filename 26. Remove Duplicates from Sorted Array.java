class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 0;
        int i = 0;
        while (i < nums.length) {
            nums[index] = nums[i];
            while (i < nums.length && nums[i] == nums[index]) {
                i++;
            }
            index++;
        }
        return index;
    }
}
