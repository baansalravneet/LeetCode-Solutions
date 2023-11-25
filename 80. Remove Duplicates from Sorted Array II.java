class Solution {
    public int removeDuplicates(int[] nums) {
        int index = 0;
        int i = 0;
        while (i < nums.length - 1) {
            if (nums[i] != nums[i+1]) {
                nums[index++] = nums[i++];
            } else {
                nums[index++] = nums[i++];
                nums[index++] = nums[i++];
                while (i < nums.length && nums[i] == nums[index-1]) i++;
            }
        }
        if (i == nums.length - 1) nums[index++] = nums[i];
        return index;
    }
}
