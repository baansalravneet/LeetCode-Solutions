class Solution {
    public int countOfPairs(int[] nums) {
        int maxValue = Arrays.stream(nums).max().getAsInt();
        int[][] dp = new int[nums.length][maxValue+1];
        for (int i = 0; i <= nums[0]; i++) {
            dp[0][i] = 1;
        }
        for (int index = 1; index < nums.length; index++) {
            for (int num1 = 0; num1 <= nums[index]; num1++) {
                int num2 = nums[index]-num1;
                for (int num1p = 0; num1p <= num1 && num1p <= nums[index-1]; num1p++) {
                    if (nums[index-1] - num1p >= num2) {
                        dp[index][num1] += dp[index-1][num1p];
                        dp[index][num1] %= (int)1e9 + 7;
                    }
                }
            }
        }
        int answer = 0;
        for (int i : dp[nums.length-1]) {
            answer += i;
            answer %= (int)1e9 + 7;
        }
        return answer;
    }
}
