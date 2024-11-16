class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i-1] + nums[i];
        }
        suffix[n-1] = nums[n-1];
        for (int i = n-2; i >= 0; i--) {
            suffix[i] = suffix[i+1] + nums[i];
        }
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                result[i] = suffix[i+1] - (n-1)*nums[i];
            } else if (i == n-1) {
                result[i] = (n-1)*nums[i] - prefix[i-1];
            } else {
                result[i] = i*nums[i] - prefix[i-1];
                result[i] += suffix[i+1] - (n-1-i)*nums[i];
            }
        }
        return result;
    }
}
