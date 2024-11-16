class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        int[] maxFromRight = new int[n];
        int[] minFromLeft = new int[n];
        maxFromRight[n-1] = nums[n-1];
        minFromLeft[0] = nums[0];
        for (int i = 1; i < n; i++) {
            minFromLeft[i] = Math.min(minFromLeft[i-1], nums[i]);
            maxFromRight[n-1-i] = Math.max(maxFromRight[n-1-i+1], nums[n-1-i]);
        }
        for (int i = 1; i < n-1; i++) {
            if (nums[i] > minFromLeft[i-1] && nums[i] < maxFromRight[i+1]) return true;
        }
        return false;
    }
}
