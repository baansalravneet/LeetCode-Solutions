class Solution:
    def findTargetSumWays(self, nums: List[int], target: int) -> int:
        @cached
        def helper(current_sum, index):
            if index == len(nums):
                return 1 if current_sum == target else 0
            return helper(current_sum+nums[index], index+1) + helper(current_sum-nums[index], index-1)
        return helper(0, 0)