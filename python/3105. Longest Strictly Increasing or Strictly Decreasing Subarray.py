class Solution:
    def longestMonotonicSubarray(self, nums: List[int]) -> int:
        answer, inc, dec = 1, 1, 1
        for i in range(1, len(nums)):
            inc = inc+1 if nums[i] > nums[i-1] else 1
            dec = dec+1 if nums[i] < nums[i-1] else 1
            answer = max(answer, inc, dec)
        return answer