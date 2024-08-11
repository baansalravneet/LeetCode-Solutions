class Solution {
    public int countOfPairs(int[] nums) {
        int maxValue = Arrays.stream(nums).max().getAsInt();
        int[][] dp = new int[nums.length][maxValue+1];
        int sum = 0;
        for (int i = 0; i <= maxValue; i++) {
            if (i <= nums[0]) sum += 1;
            dp[0][i] = sum;
        }
        for (int index = 1; index < nums.length; index++) {
            sum = 0;
            for (int num1 = 0; num1 <= maxValue; num1++) {
                int pre = Math.min(
                    num1,
                    Math.min(
                        nums[index-1],
                        nums[index-1]-nums[index]+num1
                    )
                );
                if (pre >= 0 && num1 <= nums[index]) sum += dp[index-1][pre];
                sum %= (int)1e9 + 7;
                dp[index][num1] = sum;
            }
        }
        return dp[nums.length-1][maxValue];
    }
}
