class Solution:
    def duplicateNumbersXOR(self, nums: List[int]) -> int:
        answer = 0
        for i in range(len(nums)):
            count = 0
            for j in range(i, len(nums)):
                if nums[i] == nums[j]: count += 1
            if count > 1:
                answer ^= nums[i]
        return answer