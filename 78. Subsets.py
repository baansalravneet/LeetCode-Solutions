class Solution:
    def subsets(self, nums: List[int]) -> List[List[int]]:
        result = []
        current = []
        def populate(index):
            nonlocal result, current, nums
            if index >= len(nums):
                result.append(current.copy())
                return
            populate(index+1)
            current.append(nums[index])
            populate(index+1)
            current.pop()
        populate(0)
        return result