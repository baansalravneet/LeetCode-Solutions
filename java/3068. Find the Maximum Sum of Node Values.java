class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        int n = nums.length;
        int[] netChange = new int[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            netChange[i] = (nums[i]^k)-nums[i];
            sum += nums[i];
        }
        Arrays.sort(netChange);
        for (int i = n-1; i >= 0; i -= 2) {
            if (i == 0) break;
            long pairSum = netChange[i] + netChange[i-1];
            if (pairSum > 0) sum += pairSum;
        }
        return sum;
    }
}