class Solution:
    def specialArray(self, nums: List[int]) -> int:
        nums.sort()
        for i in range(len(nums)):
            if nums[i] >= len(nums)-i:
                if i == 0 or nums[i-1] < len(nums)-i:
                    return len(nums)-i
        return -1