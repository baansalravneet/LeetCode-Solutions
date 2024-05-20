class Solution:
    def subsetXORSum(self, nums: List[int]) -> int:
        return self.sum(nums, 0, 0)
    def sum(self, nums, index, current):
        if index >= len(nums): return current
        return self.sum(nums, index+1, current) + self.sum(nums, index+1, nums[index]^current)
    