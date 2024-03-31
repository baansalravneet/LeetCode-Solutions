class Solution:
    def countAlternatingSubarrays(self, nums: List[int]) -> int:
        answer, left, right = 0, 0, 0
        while right < len(nums):
            if right == left:
                answer += 1
                right += 1
            elif nums[right] != nums[right-1]:
                answer += right - left + 1
                right += 1
            else:
                left = right
        return answer
