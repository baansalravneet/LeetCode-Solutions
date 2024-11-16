class Solution {
    public int movesToMakeZigzag(int[] nums) {
        if (nums.length == 1) return 0;
        int evenMoves = 0;
        for (int i = 0; i < nums.length; i += 2) {
            int finalValue = Integer.MAX_VALUE;
            if (i-1 >= 0) finalValue = Math.min(finalValue, nums[i-1]);
            if (i+1 < nums.length) finalValue = Math.min(finalValue, nums[i+1]);
            finalValue--;
            if (finalValue < nums[i]) evenMoves += nums[i] - finalValue;
        }
        int oddMoves = 0;
        for (int i = 1; i < nums.length; i += 2) {
            int finalValue = Integer.MAX_VALUE;
            if (i-1 >= 0) finalValue = Math.min(finalValue, nums[i-1]);
            if (i+1 < nums.length) finalValue = Math.min(finalValue, nums[i+1]);
            finalValue--;
            if (finalValue < nums[i]) oddMoves += nums[i] - finalValue;
        }
        return Math.min(evenMoves, oddMoves);
    }
}
