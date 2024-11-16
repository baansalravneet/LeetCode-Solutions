class Solution:
    def maximumLength(self, nums: List[int], k: int) -> int:
        dp = [[1] * (k+1) for i in range(len(nums))]
        answer = 0
        for x in range(k+1):
            for i in range(len(nums)):
                for j in range(i):
                    if nums[i] == nums[j]:
                        dp[i][x] = max(dp[i][x], 1+dp[j][x])
                    elif x > 0:
                        dp[i][x] = max(dp[i][x], 1+dp[j][x-1])
                answer = max(answer, dp[i][x])
        return answer
