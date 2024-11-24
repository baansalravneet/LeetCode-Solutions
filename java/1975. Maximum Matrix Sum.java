class Solution {
    public long maxMatrixSum(int[][] nums) {
        int n = nums.length;
        int smallest = Integer.MAX_VALUE;
        int count = 0;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (nums[i][j] < 0) {
                    count++;
                    smallest = Math.min(smallest, -nums[i][j]);
                    sum -= nums[i][j];
                } else {
                    smallest = Math.min(smallest, nums[i][j]);
                    sum += nums[i][j];
                }
            }
        }
        return count % 2 == 0 ? sum : sum - 2*smallest;
    }
}
