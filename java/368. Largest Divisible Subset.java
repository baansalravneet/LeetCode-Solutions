class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int[] parent = new int[nums.length];
        Arrays.fill(parent, -1);
        int maxLength = 1;
        int endIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    if (dp[i] < 1 + dp[j]) {
                        parent[i] = j;
                        dp[i] = 1 + dp[j];
                    }
                }
            }
            if (maxLength < dp[i]) {
                maxLength = dp[i];
                endIndex = i;
            }
        }
        List<Integer> answer = new ArrayList<>();
        while (endIndex != -1) {
            answer.add(nums[endIndex]);
            endIndex = parent[endIndex];
        }
        return answer;
    }
}
