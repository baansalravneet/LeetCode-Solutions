class Solution:
    def findDuplicates(self, nums: List[int]) -> List[int]:
        answer = []
        for i in range(len(nums)):
            val = abs(nums[i]) - 1
            if nums[val] < 0:
                answer.append(val + 1)
            else :
                nums[val] = -nums[val]
        return answer