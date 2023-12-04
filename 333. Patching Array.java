class Solution {
    public int minPatches(int[] nums, int n) {
        int count = 0;
        long maxPossible = 0;
        int index = 0;
        while (maxPossible < n) {
            if (index < nums.length && maxPossible+1 >= nums[index]) {
                maxPossible += nums[index++];
            } else {
                maxPossible += maxPossible + 1;
                count++;
            }
        }
        return count;
    }
}
