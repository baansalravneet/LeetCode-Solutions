class Solution {
    public boolean canSortArray(int[] nums) {
        List<List<Integer>> groups = new ArrayList<>();
        int previousMax = 0;
        for (int i = 0; i < nums.length; ) {
            int count = Integer.bitCount(nums[i]);
            int currentMin = Integer.MAX_VALUE;
            int currentMax = Integer.MIN_VALUE;
            while (i < nums.length && count == Integer.bitCount(nums[i])) {
                currentMin = Math.min(currentMin, nums[i]);
                currentMax = Math.max(currentMax, nums[i]);
                i++;
            }
            if (previousMax > currentMin) return false;
            previousMax = currentMax;
        }
        return true;
    }
}