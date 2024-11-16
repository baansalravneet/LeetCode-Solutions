class Solution {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int lmax = Integer.MIN_VALUE;
        int maxIndex = -1;
        int lmin = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = indexDifference; i < nums.length; i++) {
            int previousIndex = i - indexDifference;
            int previous = nums[previousIndex];
            if (lmax < previous) {
                lmax = previous;
                maxIndex = previousIndex;
            }
            if (lmin > previous) {
                lmin = previous;
                minIndex = previousIndex;
            }
            if (Math.abs(nums[i] - lmax) >= valueDifference) return new int[] {i, maxIndex};
            if (Math.abs(nums[i] - lmin) >= valueDifference) return new int[] {i, minIndex};
        }
        return new int[] {-1,-1};
    }
}
