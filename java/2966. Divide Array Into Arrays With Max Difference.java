class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int[][] result = new int[nums.length/3][3];
        for (int i = 0; i < nums.length; i = i + 3) {
            if (nums[i+2] - nums[i] > k) {
                return new int[][];
            }
            int row = i/3;
            result[row][i] = nums[i];
            result[row][i+1] = nums[i+1];
            result[row][i+2] = nums[i+2];
        }
        return result;
    }
}

