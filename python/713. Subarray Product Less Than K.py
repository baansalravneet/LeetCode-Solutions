class Solution:
    def numSubarrayProductLessThanK(self, nums: List[int], k: int) -> int:
        current, left, right = 1, 0, 0
        answer = 0
        while right < len(nums):
            current *= nums[right]
            while current >= k and left <= right:
                current /= nums[left]
                left += 1
            answer += right - left + 1
            right += 1
        return answer

